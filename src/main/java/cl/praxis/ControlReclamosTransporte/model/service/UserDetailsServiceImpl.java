package cl.praxis.ControlReclamosTransporte.model.service;

import cl.praxis.ControlReclamosTransporte.model.entities.Role;
import cl.praxis.ControlReclamosTransporte.model.entities.User;
import cl.praxis.ControlReclamosTransporte.model.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    private final UserRepository repository;

    public UserDetailsServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUsername(username);

        if(user == null){
            throw new UsernameNotFoundException("Usuario no Encontrado");
        }
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(), mapperRoles(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapperRoles(List<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName())).collect(Collectors.toList());
    }

}
