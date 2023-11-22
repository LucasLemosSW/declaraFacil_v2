package br.edu.ifsul.cstsi.aulas_tads_2023_2.api.infra.security;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadoresDeException {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity trataErro400(MethodArgumentNotValidException ex){ //400 - Bad Request (Erro de Validação, por exemplo)
        var erros = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(erros);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity trataErroRole(HttpMessageNotReadableException ex){ //400 - Bad Request (Erro de Validação, por exemplo)

        System.out.println("Error Message"+ex.getMessage());
        return ResponseEntity.badRequest().body("\nERRO, format data is wrong");
    }

}
