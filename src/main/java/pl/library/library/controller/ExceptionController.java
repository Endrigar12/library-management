package pl.library.library.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.library.library.handler.*;

@ControllerAdvice
public class ExceptionController {

    // For UI Pages
    @ExceptionHandler(AuthorNotFoundException.class)
    public String authorNotFoundException(AuthorNotFoundException ex) {
        return "error";
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public String categoryNotFoundException(CategoryNotFoundException ex) {
        return "error";
    }

    @ExceptionHandler(BookNotFoundException.class)
    public String bookNotFoundException(BookNotFoundException ex) {
        return "error";
    }

    @ExceptionHandler(LendNotFoundException.class)
    public String lendNotFoundException(LendNotFoundException ex) {
        return "error";
    }

    @ExceptionHandler(PublisherNotFoundException.class)
    public String publisherNotFoundException(PublisherNotFoundException ex) {
        return "error";
    }

    @ExceptionHandler(ReaderNotFoundException.class)
    public String readerNotFoundException(ReaderNotFoundException ex) {
        return "error";
    }

    // For REST APIs
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> illegalArgumentException(IllegalArgumentException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
