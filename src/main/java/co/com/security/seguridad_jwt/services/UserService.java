package co.com.security.seguridad_jwt.services;

import co.com.security.seguridad_jwt.dto.UserDto;
import co.com.security.seguridad_jwt.entity.UserEntity;
import co.com.security.seguridad_jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity guardarUser(UserDto userDto){
        UserEntity entity = new UserEntity();
        entity.setUserName(userDto.getUsuario());
        entity.setPassword(userDto.getPassword());
        //entity.setId(3L);
        return userRepository.save(entity);
    }
}
