package br.edu.ifsul.cstsi.aulas_tads_2023_2.api.usuarios;

import jakarta.validation.constraints.NotBlank;

public enum UserRole {

    ADMIN("admin"),
    USER("user");

    @NotBlank(message = "Password is mandatory")
    private String role;
    UserRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
