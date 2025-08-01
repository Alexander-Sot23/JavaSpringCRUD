package com.alexander.springboot.crud.JavaSpringCRUD.services;

import com.alexander.springboot.crud.JavaSpringCRUD.entities.User;
import com.alexander.springboot.crud.JavaSpringCRUD.exceptions.UserNotFoundException;
import com.alexander.springboot.crud.JavaSpringCRUD.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userReposiroty;

    @Override
    public List<User> findAll() {
        return userReposiroty.findAll();
    }

    @Override
    public User findById(Long id) {
        return userReposiroty.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public User save(User user) {
        return userReposiroty.save(user);
    }

    @Override
    public User update(Long id, User user) {
        User userUpdate = userReposiroty.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        userUpdate.setName(user.getName());
        userUpdate.setLastName(user.getLastName());
        userUpdate.setBirthdayDate(user.getBirthdayDate());

        return userReposiroty.save(userUpdate);
    }

    @Override
    public void delete(Long id) {
        User userDelete = userReposiroty.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        userReposiroty.delete(userDelete);
    }
}
