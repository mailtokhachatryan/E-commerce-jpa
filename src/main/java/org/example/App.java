package org.example;

import org.example.model.User;
import org.example.repository.UserRepository;
import org.example.repository.impl.UserRepositoryJpaImpl;
import org.example.service.user.UserService;
import org.example.service.user.impl.UserServiceImpl;

import java.sql.SQLException;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {

        UserRepository userRepository = new UserRepositoryJpaImpl();
        UserService userService = new UserServiceImpl(userRepository);
//        User user = userRepository.get(4L);
//        System.out.println(user);

        User user = new User();
        user.setEmail("upsadasdddasted");
        user.setLastname("LastName");
        user.setBalance(4789789);
        user.setAge(25);
        user.setPassword("askjdhaskjhd");

        userRepository.create(user);


//        userRepository.delete(7L);

        List<User> users = userRepository.findUsersByName("A");

        for (User user1 : users) {
            System.out.println(user1);
        }

    }
}
