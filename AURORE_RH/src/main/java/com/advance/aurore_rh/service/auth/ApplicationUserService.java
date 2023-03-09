package com.advance.aurore_rh.service.auth;

import com.advance.aurore_rh.dto.response.UserResponseDto;
import com.advance.aurore_rh.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@AllArgsConstructor
public class ApplicationUserService implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.advance.aurore_rh.model.User user = userRepository
                .findByUsername(username).orElseThrow(
                ()->new RuntimeException("utilisateur non trouvé")
        );

        return  new User(user.getUsername(), user.getPassword(), Collections.emptyList());
    }


    public UserResponseDto findByUserName(String username){
        com.advance.aurore_rh.model.User user =  userRepository.findByUsername(username).orElse(null);

        return UserResponseDto.builder().username((user == null)? null:user.getUsername()).build();
    }


}
