package com.alexander.springboot.crud.JavaSpringCRUD.reposiroties;

import com.alexander.springboot.crud.JavaSpringCRUD.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserReposiroty extends JpaRepository<User,Long> {
}
