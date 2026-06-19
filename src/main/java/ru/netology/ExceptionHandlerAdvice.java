// ExceptionHandlerAdvice.java
package ru.netology;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    // Обработка InvalidCredentials -> Статус 400
    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> handleInvalidCredentials(InvalidCredentials e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST) // 400
                .body(e.getMessage());
    }

    // Обработка UnauthorizedUser -> Статус 401 + Лог в консоль
    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> handleUnauthorizedUser(UnauthorizedUser e) {
        // Пишем в консоль, как требует задание
        System.out.println("[WARNING] Unauthorized access attempt: " + e.getMessage());

        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED) // 401
                .body(e.getMessage());
    }
}