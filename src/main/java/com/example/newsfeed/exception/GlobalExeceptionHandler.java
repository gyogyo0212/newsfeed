package com.example.newsfeed.exception;

import com.example.newsfeed.exception.member.DuplicateEmailException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExeceptionHandler {
    //이메일 중복 예외처리
    @ExceptionHandler(DuplicateEmailException.class)
    public ResponseEntity<String> handleDuplicateEmail(DuplicateEmailException ex) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT) // 409
                .body(ex.getMessage());
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    // @Valid 유효성 검사 통과하지 못했을 때 예외처리
    public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException ex) {
        String errorMessage = ex.getBindingResult().getFieldError().getDefaultMessage();
        return ResponseEntity.badRequest().body(errorMessage);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    //이메일이나 비밀번호 틀릴때 예외처리
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)  // 400 Bad Request
                .body(ex.getMessage());
    }
}
