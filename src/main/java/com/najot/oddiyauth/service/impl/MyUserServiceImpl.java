package com.najot.oddiyauth.service.impl;

import com.najot.oddiyauth.entity.User;
import com.najot.oddiyauth.repository.UserRepository;
import com.najot.oddiyauth.service.MyUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserServiceImpl implements MyUserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;

    @Override
    public User create(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User getUser(Integer id) {
        return null;
    }

    @Override
    public void DeleteUser(Integer id) {

    }

    @Override
    public void signIn(String username, String password) {
         Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );


        System.out.println("success");
    }
}
