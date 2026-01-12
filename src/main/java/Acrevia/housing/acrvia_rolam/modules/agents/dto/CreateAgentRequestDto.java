package Acrevia.housing.acrvia_rolam.modules.agents.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAgentRequestDto {
    @NotBlank(message = "first name is required")
    private String firstName;
    @NotBlank(message = "first name is required")
    private String lastName;
    @NotBlank(message = "first name is required")
    private String email;
}
