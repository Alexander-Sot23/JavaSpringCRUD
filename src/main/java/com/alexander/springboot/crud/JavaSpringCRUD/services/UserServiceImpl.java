package com.alexander.springboot.crud.JavaSpringCRUD.services;

import com.alexander.springboot.crud.JavaSpringCRUD.dtos.UserDTO;
import com.alexander.springboot.crud.JavaSpringCRUD.entities.User;
import com.alexander.springboot.crud.JavaSpringCRUD.exceptions.UserNotFoundException;
import com.alexander.springboot.crud.JavaSpringCRUD.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userReposiroty;

    @Override
    public Page<UserDTO> findAll(Pageable pageable) {
        return userReposiroty.findAll(pageable).map(UserDTO::new);
    }

    @Override
    public UserDTO findById(Long id) {
        User user = userReposiroty.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        return new UserDTO(user);
    }

    @Override
    public UserDTO save(User user) {
        User saveUser = userReposiroty.save(user);
        return new UserDTO(saveUser);
    }

    @Override
    public Set<UserDTO> saveAll(List<User> users) {
        return userReposiroty.saveAll(users).stream()
                .map(UserDTO::new)
                .collect(Collectors.toSet());
    }

    @Override
    public UserDTO update(Long id, User user) {
        User userUpdate = userReposiroty.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        userUpdate.setName(user.getName());
        userUpdate.setLastName(user.getLastName());
        userUpdate.setBirthdayDate(user.getBirthdayDate());

        User updateUser = userReposiroty.save(userUpdate);
        return new UserDTO(updateUser);
    }

    @Override
    public void delete(Long id) {
        User userDelete = userReposiroty.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        userReposiroty.delete(userDelete);
    }
}
