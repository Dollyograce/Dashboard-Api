package adepojugrace.dolly.domain.book.controller;

import adepojugrace.dolly.domain.book.exception.BookNotFoundException;
import adepojugrace.dolly.domain.book.model.Book;
import adepojugrace.dolly.domain.book.services.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("top21books")

public class BookController {

    private static Logger logger = LoggerFactory.getLogger(BookController.class);

    private BookService bookService;

    @Autowired

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Book>> requestBook(@PathVariable Long id) throws BookNotFoundException {
        List<Book> response = bookService.requestBook();
        logger.info(response.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Book>> requestBook () throws BookNotFoundException {
        List <Book> response = bookService.requestBook();
        return new ResponseEntity(response, HttpStatus.OK);
    }
}



