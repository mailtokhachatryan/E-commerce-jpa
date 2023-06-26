package org.example.service.user.impl;


import org.example.exceptions.UserNotFoundException;
import org.example.exceptions.ValidationException;
import org.example.model.User;
import org.example.repository.UserRepository;
import org.example.service.user.UserService;
import org.example.util.constants.Message;
import org.example.util.encoder.MD5Encoder;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void register(User user) throws Exception {
        validationForRegistration(user);
        user.setPassword(MD5Encoder.encode(user.getPassword()));
        userRepository.create(user);
        System.out.println(user.getName() + " you are registered successfully");
    }

    @Override
    public void login(String email, String password) throws Exception {
        validationForLogin(email, password);

        String encoded = MD5Encoder.encode(password);

        User loginedUser = userRepository.findUsersByEmail(email);
        if (!loginedUser.getPassword().equals(encoded)) {
            throw new ValidationException("Invalid login or password");
        }
    }

    @Override
    public void changePassword(String email, String newPassword, String repeatPassword) {

        if (!newPassword.equals(repeatPassword)) {
            throw new ValidationException("Passwords not matches");
        }
        var usersByEmail = userRepository.findUsersByEmail(email);
        if (usersByEmail == null)
            throw new UserNotFoundException(Message.USER_NOT_FOUND);

        usersByEmail.setPassword(MD5Encoder.encode(newPassword));
        try {
            userRepository.update(usersByEmail);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    private void validationForRegistration(User user) throws Exception {
        if (user.getEmail() == null ||
                user.getEmail().length() == 0 ||
                !user.getEmail().matches("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*"
                        + "@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$"))
            throw new Exception("something with email is wrong");
        if (user.getPassword() == null ||
                user.getPassword().length() < 8
        )
            throw new Exception("password validation is wrong");
    }

    private void validationForLogin(String email, String password) {
        if (email == null || password == null || email.isEmpty() || password.isEmpty())
            throw new ValidationException(Message.EMAIL_OR_PASSWORD_IS_NULL);
    }
}
