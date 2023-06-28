package org.example.repository.address;

import org.example.model.Address;
import org.example.util.HibernateUtil;
import org.hibernate.SessionFactory;

import java.util.List;

public class AddressRepositoryJpaImpl implements AddressRepository {

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public void create(Address address) {
        var session = sessionFactory.openSession();
        var transaction = session.beginTransaction();
        session.save(address);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Address user) {

    }

    @Override
    public Address get(Long id) {
        var session = sessionFactory.openSession();
        var address = session.get(Address.class, id);
        session.close();
        return address;
    }

    @Override
    public List<Address> getAll() {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
