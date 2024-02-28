package com.najot.oddiyauth.service;

import com.najot.oddiyauth.entity.User;

public interface MyUserService {
    User create(User user);
    User getUser(Integer id);
    void DeleteUser(Integer id);
    void signIn(String username, String password);
}
