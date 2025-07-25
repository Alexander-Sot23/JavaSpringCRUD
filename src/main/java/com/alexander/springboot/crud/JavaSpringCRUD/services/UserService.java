package com.alexander.springboot.crud.JavaSpringCRUD.services;

import com.alexander.springboot.crud.JavaSpringCRUD.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();

    Optional<User> findById(Long id);

    User save(User user);

    Optional<User> update(Long id, User user);

    Optional<User> delete(Long id);

}
