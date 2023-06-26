package org.example.service.user;


import org.example.model.User;

public interface UserService {

    void register(User user) throws Exception;

    void login(String email, String password) throws Exception;

    void changePassword(String username, String newPassword, String repeatPassword);
}
