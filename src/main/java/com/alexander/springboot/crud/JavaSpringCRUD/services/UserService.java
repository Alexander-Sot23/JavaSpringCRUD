package com.alexander.springboot.crud.JavaSpringCRUD.services;

import com.alexander.springboot.crud.JavaSpringCRUD.entities.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(Long id);

    User save(User user);

    User update(Long id, User user);

    void delete(Long id);

}
