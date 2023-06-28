package org.example.repository.address;


import org.example.model.Address;

import java.util.List;

public interface AddressRepository {

    void create(Address user);

    void update(Address user);

    Address get(Long id);

    List<Address> getAll();

    void delete(Long id);

}