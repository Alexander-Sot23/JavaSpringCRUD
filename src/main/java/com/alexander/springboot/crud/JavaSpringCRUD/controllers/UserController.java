package com.alexander.springboot.crud.JavaSpringCRUD.controllers;

import com.alexander.springboot.crud.JavaSpringCRUD.entities.User;
import com.alexander.springboot.crud.JavaSpringCRUD.services.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("")
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<User> userDB = userService.findById(id);
        if(userDB.isPresent()){
            var userF = userDB.get();
            return ResponseEntity.status(HttpStatus.OK).body(userF);
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("")
    public ResponseEntity<?> create(@Valid @RequestBody User user, BindingResult result){
        if(result.hasFieldErrors()){
            return validation(result);
        }
        User userC = userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userC);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody User user ,@PathVariable Long id, BindingResult result){
        if(result.hasFieldErrors()){
            return validation(result);
        }
        Optional<User> userDBO = userService.findById(id);
        if(userDBO.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(userService.update(id,user));
        }
        return ResponseEntity.badRequest().body("El id " + id + ", no pertenece a ningun usuario en la base de datos!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<User> userDBO = userService.findById(id);
        if(userDBO.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(userService.delete(id));
        }
        return ResponseEntity.badRequest().body("El id " + id + ", no pertenece a ningun usuario en la base de datos!");
    }

    private ResponseEntity<?> validation(BindingResult result) {
        Map<String, String> errors = new HashMap<>();

        result.getFieldErrors().forEach(error -> {
            errors.put(error.getField(),"El campo " + error.getField() + " " + error.getDefaultMessage());
        });

        return ResponseEntity.badRequest().body(errors);
    }

}
