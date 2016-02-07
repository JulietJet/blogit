package com.jahra.service.impl.authentication;

import com.jahra.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author a.vorushenko
 */
@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    UserService userService;
    @Autowired
    BCryptPasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        com.jahra.model.User user = userService.findByUsername(s);
        if (user == null) {
            throw new UsernameNotFoundException("No user with such username");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        SimpleGrantedAuthority userAuthority = new SimpleGrantedAuthority(UserRoles.USER.getRole());
        SimpleGrantedAuthority adminAuthority = new SimpleGrantedAuthority(UserRoles.ADMIN.getRole());
        String role = user.getUserRole();
        if (UserRoles.USER.getRole().equals(role))
            authorities.add(userAuthority);
        else if (UserRoles.ADMIN.getRole().equals(role)) {
            authorities.add(userAuthority);
            authorities.add(adminAuthority);
        }
        return new User(user.getUsername(), user.getPassword(),
                user.isUserEnabled(), true, true, true, authorities);
    }
}
