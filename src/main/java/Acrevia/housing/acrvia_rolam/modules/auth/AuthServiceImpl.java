package Acrevia.housing.acrvia_rolam.modules.auth;

import Acrevia.housing.acrvia_rolam.entities.User;
import Acrevia.housing.acrvia_rolam.modules.auth.dto.CreateUserRequestDto;
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
//                .orElseThrow(() -> new BadRequestException("User not found"))
        if (userExists.isPresent()){
            System.out.println("User already exists ");
//            throw  new BadRequestException("User with the email exists");
        }

        User newUser = new User();
        newUser.setEmail(data.getEmail());
        newUser.setFirstName(data.getFirstName());
        newUser.setLastName(data.getLastName());

        authRepository.save(newUser);
        return newUser;
    }
}
