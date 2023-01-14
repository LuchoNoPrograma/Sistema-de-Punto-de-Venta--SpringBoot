package com.example.demo.model.dto;

import com.example.demo.model.entidades.Persona;
import com.example.demo.model.entidades.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private Long idUsuario;
    private String username;
    private String password;
    private Persona persona;
    public static User copyFromEntity(User user){
        return new User(user.getIdUsuario(), user.getUsername(), user.getPassword(), user.getPersona());
    }
}
