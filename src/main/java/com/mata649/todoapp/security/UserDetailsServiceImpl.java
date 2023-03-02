package com.mata649.todoapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mata649.todoapp.user.domain.User;
import com.mata649.todoapp.user.domain.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userFound = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("invalid credentials"));

        return new UserDetailsImpl(userFound);
    }

}
