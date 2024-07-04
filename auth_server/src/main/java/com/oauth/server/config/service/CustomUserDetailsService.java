package com.oauth.server.config.service;

import com.oauth.server.persistence.model.User;
import com.oauth.server.persistence.model.UserRole;
import com.oauth.server.persistence.repository.IUserRepository;
import com.oauth.server.persistence.repository.IUserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IUserRoleRepository userRoleRepository;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(11);
    }



    private Collection<? extends GrantedAuthority> getAuthorities(List<UserRole> userRoles) {
        List<GrantedAuthority>  authorities = new ArrayList<>();

        for(UserRole userRole : userRoles){
            authorities.add(new SimpleGrantedAuthority(userRole.getRole().getRoleName()));
        }
        System.out.println("authorities:"+authorities.toString());
        return authorities;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if(user == null) {
            throw  new UsernameNotFoundException("No User Found");
        }

        List<UserRole> userRoles = userRoleRepository.findByUserId(user.getId());

        if(userRoles == null) {
            throw  new UsernameNotFoundException("No User Roles Found");
        }
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                user.isEnabled(),
                true,
                true,
                true,
                getAuthorities(userRoles));
    }
}
