package react.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by nickstanogias on 15/04/18.
 */
@Document(collection = "books")
public class Book {

    @Id
    String id;
    String title;
    String description;
    String author;
    Integer rating;

    public Book() {
    }

    public Book(String title, String description, String author, Integer rating) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
