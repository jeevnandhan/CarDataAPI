package com.kickoffHandsOn.wings1_t4_car_data_api.config;

import com.kickoffHandsOn.wings1_t4_car_data_api.model.UserDetail;
import com.kickoffHandsOn.wings1_t4_car_data_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class CarDataUsernamePwdAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        List<UserDetail> users = userRepository.findByusername(username);
        if(!users.isEmpty()){
            if(passwordEncoder.matches(password,users.get(0).getPassword())){
                return new UsernamePasswordAuthenticationToken(username, password, getGrantedAuthorities(users.get(0).getRole()));
            } else{
                throw new BadCredentialsException("Invalid Password");
            }
        }
        throw new BadCredentialsException("No user registered with the details");
    }

    private Collection<? extends GrantedAuthority> getGrantedAuthorities(String role) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(role));
        return grantedAuthorities;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
