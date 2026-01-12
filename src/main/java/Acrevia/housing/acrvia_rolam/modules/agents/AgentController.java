package Acrevia.housing.acrvia_rolam.modules.agents;

import Acrevia.housing.acrvia_rolam.entities.Agent;
import Acrevia.housing.acrvia_rolam.modules.agents.dto.CreateAgentRequestDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/agents")
@RequiredArgsConstructor
public class AgentController {
    private final AgentService agentService;

    @GetMapping()
    public ResponseEntity<List<Agent>> getAllAgents() {
        List<Agent> agents = agentService.getAllAgents();
        return  new ResponseEntity<>(
                agents,
                HttpStatus.OK
        );
    }

    @PostMapping()
    public  ResponseEntity<Agent> createAgent (
            @Valid @RequestBody CreateAgentRequestDto data
            ) {
        Agent createdAgent = agentService.createAgent(data);
        return  new ResponseEntity<>(
                createdAgent,
                HttpStatus.CREATED
        );
    }

}
