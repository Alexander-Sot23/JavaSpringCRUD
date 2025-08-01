package com.alexander.springboot.crud.JavaSpringCRUD.repositories;

import com.alexander.springboot.crud.JavaSpringCRUD.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
