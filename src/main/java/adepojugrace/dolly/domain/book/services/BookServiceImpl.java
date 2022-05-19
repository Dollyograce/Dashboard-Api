package adepojugrace.dolly.domain.book.services;

import adepojugrace.dolly.domain.book.exception.BookNotFoundException;
import adepojugrace.dolly.domain.book.model.Book;

import adepojugrace.dolly.domain.book.repo.BookRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Optional;
import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    private Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

    private RestTemplate restTemplate;
    private BookRepo bookRepo;

    @Value("${book.api.host}")
    private String host;

    @Value("${book.api.key}")
    private String key;

    //What our container needs for this service implementation
    @Autowired
    public BookServiceImpl() {
        this.restTemplate = new RestTemplate();
        this.bookRepo = bookRepo;
    }

    @PostConstruct
   public void setup(){
        requestBookFromApi();
   }

    @Override
    public List<Book> requestBook() throws BookNotFoundException {
        Optional<List<Book>> optional = requestBookFromApi();
        if(optional.isEmpty()) {
            throw new BookNotFoundException("Book not found");
        }
        return optional.get();
    }



    @Override
    public Book save(Book book) {
        return bookRepo.save(book);
    }



    private Optional<List<Book>> requestBookFromApi() {
        try { //goes along with the optional, it's either you return an object or dont
            String uri = "https://hapi-books.p.rapidapi.com/top/2021";
            //Take in the information like the host and key
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("X-RapidAPI-Host", host);
            httpHeaders.set("X-RapidAPI-Key", key);
            //Taking in the username and password - encapsulates the header and the body of an HTTP request or response
            HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
            //Encapsulating all the information to provide a response
            ResponseEntity<ArrayList<Book>> response = restTemplate.exchange(uri, HttpMethod.GET, entity, new ParameterizedTypeReference<>() {});
            ArrayList<Book> books = response.getBody();
            logger.info(books.get(1).toString());
            return Optional.of(books);
        } catch (HttpClientErrorException ex) {
            return Optional.empty();
        }
    }


}
