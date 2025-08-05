package com.alexander.springboot.crud.JavaSpringCRUD.services;

import com.alexander.springboot.crud.JavaSpringCRUD.dtos.UserDTO;
import com.alexander.springboot.crud.JavaSpringCRUD.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;

public interface UserService {

    Page<UserDTO> findAll(Pageable pageable);
    UserDTO findById(Long id);
    UserDTO save(User user);
    Set<UserDTO> saveAll(List<User> users);
    UserDTO update(Long id, User user);
    void delete(Long id);

}
