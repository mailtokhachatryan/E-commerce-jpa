package org.example;

import org.example.model.Account;
import org.example.model.Address;
import org.example.model.User;
import org.example.repository.address.AddressRepository;
import org.example.repository.address.AddressRepositoryJpaImpl;
import org.example.repository.user.UserRepository;
import org.example.repository.user.impl.UserRepositoryJpaImpl;
import org.example.service.user.UserService;
import org.example.service.user.impl.UserServiceImpl;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigDecimal;
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

        userService.printAddresses(2L);

//        User user = userRepository.get(4L);
////        System.out.println(user);
//
//        User user = new User();
//        user.setEmail("upsadasdddasted");
//        user.setLastname("LastName");
//        user.setBalance(4789789);
//        user.setAge(25);
//        user.setPassword("askjdhaskjhd");
//        user.setAccount(Account.builder().balance(new BigDecimal(2500)).build());
//
//        userRepository.create(user);
//
//        var address = Address.builder().address("Yerevan").user(user).build();
//        var addressRepository = new AddressRepositoryJpaImpl();
//
//        addressRepository.create(address);
//


    }
}
