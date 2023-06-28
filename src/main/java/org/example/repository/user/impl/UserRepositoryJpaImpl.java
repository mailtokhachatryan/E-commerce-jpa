package org.example.repository.user.impl;

import org.example.model.User;
import org.example.repository.user.UserRepository;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.sql.SQLException;
import java.util.List;

public class UserRepositoryJpaImpl implements UserRepository {

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public void create(User user) throws SQLException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(user);

        transaction.commit();
        session.close();
    }

    @Override
    public void update(User user) throws SQLException {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.update(user);

        transaction.commit();
        session.close();
    }

    @Override
    public List<User> getAll() throws SQLException {
        return null;
    }

    @Override
    public User get(Long id, Session session) throws SQLException {
        return session.get(User.class, id);
    }

    @Override
    public List<User> findUsersByName(String name) throws SQLException {
        Session session = sessionFactory.openSession();
        NativeQuery<User> nativeQuery = session.createNativeQuery(
                "SELECT * FROM users WHERE lower(name) LIKE lower(concat('%',:name,'%'));",
                User.class
        );
        nativeQuery.setParameter("name", name);
        return nativeQuery.getResultList();
    }

    @Override
    public void delete(Long id) throws SQLException {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User o = get(id,session);
        session.delete(o);
        transaction.commit();
        session.close();
    }

    @Override
    public User findUsersByEmail(String email) {
        return null;
    }
}
