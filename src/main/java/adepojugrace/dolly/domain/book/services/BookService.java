package adepojugrace.dolly.domain.book.services;

import adepojugrace.dolly.domain.book.exception.BookNotFoundException;
import adepojugrace.dolly.domain.book.model.Book;

import java.util.List;

public interface BookService {

    List<Book> requestBook() throws BookNotFoundException;
    Book save (Book book);
}
