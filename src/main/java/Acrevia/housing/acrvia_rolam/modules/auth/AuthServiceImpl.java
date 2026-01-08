package Acrevia.housing.acrvia_rolam.modules.auth;

import Acrevia.housing.acrvia_rolam.entities.User;
import Acrevia.housing.acrvia_rolam.modules.auth.dto.CreateUserRequestDto;
import Acrevia.housing.acrvia_rolam.modules.auth.dto.LoginUserRequestDto;
import Acrevia.housing.acrvia_rolam.shared.exceptions.UserAlreadyExistsException;
import Acrevia.housing.acrvia_rolam.shared.exceptions.UserNotFoundException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements  AuthService {
    private final AuthRepository authRepository;


    @Override
    public User createUser(CreateUserRequestDto data)  {
        Optional<User>  userExists = authRepository.findByEmail(data.getEmail());
        if (userExists.isPresent()){
            System.out.println("User already exists ");
            throw  new UserAlreadyExistsException("User with the email:" + data.getEmail() + " already exists");
        }

        User newUser = new User();
        newUser.setEmail(data.getEmail());
        newUser.setFirstName(data.getFirstName());
        newUser.setLastName(data.getLastName());
        authRepository.save(newUser);

    //        set and hash  the password.

    // send the welcome email to the user.

        return newUser;
    }

    @Override
    public User loginUser(LoginUserRequestDto data) {
        Optional<User> user = authRepository.findByEmail(data.getEmail());

        if (user.isEmpty()) {
            throw  new UserNotFoundException("User not found");
        }
//        generate the jwt password

//        return the user.
        return  user.get();
    }
}
