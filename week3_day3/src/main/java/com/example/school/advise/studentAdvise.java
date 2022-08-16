package com.example.school.advise;

import com.example.school.dto.ApiResponse;
import com.example.school.exception.ApiException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class studentAdvise {
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> MethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException){
        String message=methodArgumentNotValidException.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(new ApiResponse(message,400));

    }@ExceptionHandler(value = ApiException.class)
    public ResponseEntity<ApiResponse> ApiResponseException() {
        return ApiResponseException(null);
    }



    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity<ApiResponse> ApiResponseException(ApiException apiException){
        String message=apiException.getMessage();
        return ResponseEntity.status(400).body(new ApiResponse(message,400));
    }

    @ExceptionHandler(value= Exception.class)
    public ResponseEntity<ApiResponse> Exception(Exception exception){
        exception.printStackTrace();
        return ResponseEntity.status(500).body(new ApiResponse("Server error", 500));
    }
}
