package Acrevia.housing.acrvia_rolam.modules.agents;

import Acrevia.housing.acrvia_rolam.entities.Agent;
import Acrevia.housing.acrvia_rolam.modules.agents.dto.CreateAgentRequestDto;

import java.util.List;

public interface AgentServiceInterface {
    Agent createAgent(CreateAgentRequestDto data);
//    Agent findByEmail( )
    List<Agent> getAllAgents();
}
