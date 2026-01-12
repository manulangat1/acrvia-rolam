package Acrevia.housing.acrvia_rolam.shared;

import Acrevia.housing.acrvia_rolam.shared.dto.ErrorDto;
import Acrevia.housing.acrvia_rolam.shared.exceptions.AgentExistsException;
import Acrevia.housing.acrvia_rolam.shared.exceptions.AgentNotFoundException;
import Acrevia.housing.acrvia_rolam.shared.exceptions.UserAlreadyExistsException;
import Acrevia.housing.acrvia_rolam.shared.exceptions.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalErrorException {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDto> handleUserNotFoundException(UserNotFoundException ex) {
        log.error("User not found");
        ErrorDto errorDto = new ErrorDto();
        errorDto.setError("User not found");
        return  new ResponseEntity<ErrorDto>(errorDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public  ResponseEntity<ErrorDto> handleUserAlreadyExistsException( UserAlreadyExistsException ex ) {
        log.error("User already exists.");
        ErrorDto errorDto = new ErrorDto();
        errorDto.setError("User not found");
        return  new ResponseEntity<ErrorDto>(errorDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AgentNotFoundException.class)
    public ResponseEntity<ErrorDto> handleAgentNotFound ( AgentNotFoundException ex) {
        log.error("Agent not found.");
        ErrorDto errorDto = new ErrorDto();
        errorDto.setError("Agent not found");
        return  new ResponseEntity<ErrorDto>(errorDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AgentExistsException.class)
    public  ResponseEntity<ErrorDto> handleAgentAlreadyExists (AgentExistsException ex) {

        log.error("Agent already exists.");
        ErrorDto errorDto = new ErrorDto();
        errorDto.setError("Agent already exists found");
        return  new ResponseEntity<ErrorDto>(errorDto, HttpStatus.BAD_REQUEST);

    }
}
