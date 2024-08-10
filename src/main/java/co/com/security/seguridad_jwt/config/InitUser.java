package co.com.security.seguridad_jwt.config;

import co.com.security.seguridad_jwt.dto.UserDto;
import co.com.security.seguridad_jwt.entity.UserEntity;
import co.com.security.seguridad_jwt.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/*@Component
public class InitUser implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        UserDto userDto = new UserDto();
        userDto.setUsuario("fenix");
        userDto.setPassword(passwordEncoder.encode("12345"));
        userService.guardarUser(userDto);
    }
}*/
