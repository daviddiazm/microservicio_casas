package com.daviddiazm.housing.category.infrastructure.exceptionshandler;

import com.daviddiazm.housing.category.domain.exceptions.NameMaxException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerAdvisor {

//    como funciona esto?
    @ExceptionHandler(NameMaxException.class)
    public ResponseEntity<ExceptionResponse> handleNameMaxSizeExceededException(NameMaxException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.NAME_MAX_SIZE_MESSAGE, LocalDateTime.now()));
    }


}
