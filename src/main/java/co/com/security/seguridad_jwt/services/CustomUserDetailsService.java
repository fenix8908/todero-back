package co.com.security.seguridad_jwt.services;

import co.com.security.seguridad_jwt.entity.UserEntity;
import co.com.security.seguridad_jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUserName(username);
        if(user == null){
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        return new User(user.getUserName(),
                        user.getPassword(),
                        AuthorityUtils.createAuthorityList(user.getRole()));
    }
}
