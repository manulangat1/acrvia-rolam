package Acrevia.housing.acrvia_rolam.modules.auth;


import Acrevia.housing.acrvia_rolam.entities.User;
import Acrevia.housing.acrvia_rolam.modules.auth.dto.CreateUserRequestDto;
import Acrevia.housing.acrvia_rolam.modules.auth.dto.LoginUserRequestDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
private  final  AuthService authService;
    @GetMapping
    public ResponseEntity<String> getLoggedInUser() {
        return  new ResponseEntity("Hello world", HttpStatus.OK);
    }

    @PostMapping(path = "/signup/")
    public  ResponseEntity<String> signup(
            @Valid @RequestBody CreateUserRequestDto data
            ) {
        User user = authService.createUser(data);
        return  new ResponseEntity<>("User sign up successfully", HttpStatus.CREATED);
    }

    @PostMapping(path = "/login/")
    public  ResponseEntity<User> login(
            @Valid @RequestBody LoginUserRequestDto data
            ) {
        User user = authService.loginUser(data);
        return  new ResponseEntity<>(user, HttpStatus.OK);
    }
}
