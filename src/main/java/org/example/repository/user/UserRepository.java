package org.example.repository.user;


import org.example.model.User;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public interface UserRepository {

    void create(User user) throws SQLException;

    void update(User user) throws SQLException;

    User get(Long id, Session session) throws SQLException;

    List<User> getAll() throws SQLException;

    List<User> findUsersByName(String name) throws SQLException;

    void delete(Long id) throws SQLException;

    User findUsersByEmail(String email);
}