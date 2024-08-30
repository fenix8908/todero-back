package co.com.toderoback.app.services;

import co.com.toderoback.app.repository.UserRepository;
import co.com.toderoback.app.dto.UserDto;
import co.com.toderoback.app.entity.UserEntity;
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
