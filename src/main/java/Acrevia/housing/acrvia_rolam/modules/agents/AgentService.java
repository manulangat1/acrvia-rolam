package Acrevia.housing.acrvia_rolam.modules.agents;

import Acrevia.housing.acrvia_rolam.entities.Agent;
import Acrevia.housing.acrvia_rolam.modules.agents.dto.CreateAgentRequestDto;
import Acrevia.housing.acrvia_rolam.shared.exceptions.AgentExistsException;
import Acrevia.housing.acrvia_rolam.shared.exceptions.AgentNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AgentService implements  AgentServiceInterface {

    private  final AgentRepository agentRepository;

   private Agent findByEmail(String email) {

       Optional<Agent> agent = agentRepository.findByEmail( email);

       if (agent.isEmpty()) {
           throw  new AgentNotFoundException("Agent not found");
       }

       return  agent.get();
    }

    @Override
    public List<Agent> getAllAgents() {
        return agentRepository.findAll();
    }

    @Override
    public Agent createAgent(CreateAgentRequestDto data) {
       Optional<Agent> agent = agentRepository.findByEmail(data.getEmail());
       if ( agent.isPresent()) {
           throw new AgentExistsException("Agent exists with provided details.");
       }
       Agent newAgent = new Agent();
       newAgent.setEmail(data.getEmail());
       newAgent.setFirstName(data.getFirstName());
       newAgent.setLastName(data.getLastName());
       agentRepository.save(newAgent);
       return  newAgent;
    }

}
