package co.com.toderoback.app.services;

import co.com.toderoback.app.repository.UserRepository;
import co.com.toderoback.app.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

        /*Set<GrantedAuthority> authorities = user.getRoles().stream()
                .flatMap(role -> role.getPermisos().stream()) // Obtener todos los permisos de los roles
                .map(permiso -> new SimpleGrantedAuthority(permiso.getNombre())) // Convertir permisos a GrantedAuthority
                .collect(Collectors.toSet());*/
        Set<GrantedAuthority> authorities = user.getRoles().stream()
                .map(rol -> new SimpleGrantedAuthority(rol.getNombre()))
                .collect(Collectors.toSet());

        return new User(user.getUserName(), user.getPassword(), authorities);
    }
}
