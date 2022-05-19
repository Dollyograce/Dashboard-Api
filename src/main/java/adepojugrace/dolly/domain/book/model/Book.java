package adepojugrace.dolly.domain.book.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@JsonIgnoreProperties(ignoreUnknown = true)
//Specifies the object that is mapped to the database
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    @JsonIgnoreProperties({"book_id"})
    private Integer book_id;
    private String name;
    private String winning_category;
    private String cover;
    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWinning_category() {
        return winning_category;
    }

    public void setWinning_category(String winning_category) {
        this.winning_category = winning_category;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", name='" + name + '\'' +
                ", winning_category='" + winning_category + '\'' +
                ", cover='" + cover + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}

