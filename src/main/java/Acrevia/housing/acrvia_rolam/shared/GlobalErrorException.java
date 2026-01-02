package Acrevia.housing.acrvia_rolam.shared;

import Acrevia.housing.acrvia_rolam.shared.dto.ErrorDto;
import Acrevia.housing.acrvia_rolam.shared.exceptions.UserNotFoundExecption;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalErrorException {

    @ExceptionHandler(UserNotFoundExecption.class)
    public ResponseEntity<ErrorDto> handleUserAlreadyExists(UserNotFoundExecption ex) {
        log.error("User not found");
        ErrorDto errorDto = new ErrorDto();
        errorDto.setError("User not found");
        return  new ResponseEntity<ErrorDto>(errorDto, HttpStatus.BAD_REQUEST);
    }
}
