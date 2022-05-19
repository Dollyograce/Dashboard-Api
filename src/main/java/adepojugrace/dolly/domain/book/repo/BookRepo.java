package adepojugrace.dolly.domain.book.repo;

import adepojugrace.dolly.domain.book.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BookRepo extends CrudRepository<Book, Long>{
    Optional<Book> findById(Long id);
}

