package br.edu.ifsul.cstsi.aulas_tads_2023_2.api.infra.security;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterDTO(

        @Email(message = "Email should be valid")
        @NotBlank(message = "Name is mandatory")
        String email,
        @NotBlank(message = "Name is mandatory")
        String nome,
        @NotBlank(message = "Sobrenome is mandatory")
        String sobrenome,
        @Size(min = 5, max = 21, message
                = "Your password must have a size between 5 and 21 characters")
        @NotBlank(message = "Password is mandatory")
        String password
        ) {

}
