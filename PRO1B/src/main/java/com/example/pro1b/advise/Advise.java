package com.example.pro1b.advise;


import com.example.pro1b.Exception.ApiException;
import com.example.pro1b.dto.ApiResponse;
import org.hibernate.mapping.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Advise {
    @ExceptionHandler(value =DataIntegrityViolationException.class)
    public ResponseEntity DataIntegrityViolation(DataIntegrityViolationException dataIntegrityViolationException){
        String message="this username is alresdy used";
        return ResponseEntity.status(400).body(new ApiResponse(message,400));

    }

    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity apiException(ApiException apiException){

        return ResponseEntity.status(500).body(new ApiResponse("Server Error",500));

    }


}
