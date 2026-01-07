package Acrevia.housing.acrvia_rolam.modules.auth;

import Acrevia.housing.acrvia_rolam.entities.User;
import Acrevia.housing.acrvia_rolam.modules.auth.dto.CreateUserRequestDto;
import Acrevia.housing.acrvia_rolam.modules.auth.dto.LoginUserRequestDto;
import org.apache.coyote.BadRequestException;

public interface AuthService {
    User createUser ( CreateUserRequestDto data);

    User loginUser(LoginUserRequestDto data) ;
}
