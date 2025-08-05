package com.alexander.springboot.crud.JavaSpringCRUD.dtos;

import com.alexander.springboot.crud.JavaSpringCRUD.entities.User;
import lombok.Getter;

@Getter
public class UserDTO {

    private Long id;
    private String name;
    private String lastName;
    private String birthdayDate;

    public  UserDTO(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.lastName = user.getLastName();
        this.birthdayDate = user.getBirthdayDate();
    }

}
