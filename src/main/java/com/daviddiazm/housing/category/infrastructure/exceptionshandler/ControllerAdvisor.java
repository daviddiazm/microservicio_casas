package com.daviddiazm.housing.category.infrastructure.exceptionshandler;

import com.daviddiazm.housing.category.domain.exceptions.*;
import com.daviddiazm.housing.category.domain.utils.constants.DomainConstants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerAdvisor {

//    como funciona esto?



    @ExceptionHandler(CategoryNotExistException.class)
    public ResponseEntity<ExceptionResponse> handleCategoryNoExistExceededException(CategoryNotExistException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(DomainConstants.CATEGORY_NO_EXIST, LocalDateTime.now()));
    }

    @ExceptionHandler(DescriptionMaxException.class)
    public ResponseEntity<ExceptionResponse> handleDescriptionMaxSizeExceededException(DescriptionMaxException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(DomainConstants.DESCRIPTION_MAX_LENGHT, LocalDateTime.now()));
    }

    @ExceptionHandler(DescriptionMinException.class)
    public ResponseEntity<ExceptionResponse> handleDescriptionMinSizeExceededException(DescriptionMinException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(DomainConstants.DESCRIPTION_MIN_LENGHT, LocalDateTime.now()));
    }

    @ExceptionHandler(NameAlreadyExistException.class)
    public ResponseEntity<ExceptionResponse> handleNameAlreadyExistExceededException(NameAlreadyExistException exception) {
        return ResponseEntity.status(409).body(new ExceptionResponse(DomainConstants.NAME_ALREADY_EXIST, LocalDateTime.now()));
    }

    @ExceptionHandler(NameMaxException.class)
    public ResponseEntity<ExceptionResponse> handleNameMaxSizeExceededException(NameMaxException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.NAME_MAX_SIZE_MESSAGE, LocalDateTime.now()));
    }

    @ExceptionHandler(NameMinException.class)
    public ResponseEntity<ExceptionResponse> handleNameMinSizeExceededException(NameMinException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(DomainConstants.NAME_MIN_LENGHT, LocalDateTime.now()));
    }

    @ExceptionHandler(PageMinNumbrePageException.class)
    public ResponseEntity<ExceptionResponse> handlePageMintExceededException(PageMinNumbrePageException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(DomainConstants.PAGE_MIN_VALUE_PAGE, LocalDateTime.now()));
    }

    @ExceptionHandler(PageMinNumbreSizeException.class)
    public ResponseEntity<ExceptionResponse> handlePageSizeMintExceededException(PageMinNumbreSizeException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(DomainConstants.PAGE_MIN_VALUE_SIZE, LocalDateTime.now()));
    }



}
