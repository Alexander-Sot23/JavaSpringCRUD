package com.alexander.springboot.crud.JavaSpringCRUD.services;

import com.alexander.springboot.crud.JavaSpringCRUD.entities.User;
import com.alexander.springboot.crud.JavaSpringCRUD.reposiroties.UserReposiroty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserReposiroty userReposiroty;

    @Override
    public List<User> findAll() {
        return userReposiroty.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userReposiroty.findById(id);
    }

    @Override
    public User save(User user) {
        return userReposiroty.save(user);
    }

    @Override
    public Optional<User> update(Long id, User user) {
        Optional<User> userDB = userReposiroty.findById(id);
        if(userDB.isPresent()){
            User userU = userDB.orElseThrow();
            userU.setName(user.getName());
            userU.setLastName(user.getLastName());
            userU.setBirthdayDate(user.getBirthdayDate());

            return Optional.of(userReposiroty.save(userU));
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> delete(Long id) {
        Optional<User> userDB = userReposiroty.findById(id);
        userDB.ifPresent(u -> {
            userReposiroty.delete(u);
        });
        return userDB;
    }
}
