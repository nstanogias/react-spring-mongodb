package react.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import react.model.Book;
import react.repositories.BookRepository;

import java.util.Optional;

/**
 * Created by nickstanogias on 15/04/18.
 */
@RestController
public class BookController {
    @Autowired
    BookRepository bookRepository;

    @RequestMapping(method= RequestMethod.GET, value="/books")
    public Iterable<Book> book() {
        return bookRepository.findAll();
    }

    @RequestMapping(method=RequestMethod.POST, value="/books")
    public Book save(@RequestBody Book book) {
        bookRepository.save(book);

        return book;
    }

    @RequestMapping(method=RequestMethod.GET, value="/books/{id}")
    public Optional<Book> show(@PathVariable String id) {
        return bookRepository.findById(id);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/books/{id}")
    public Book update(@PathVariable String id, @RequestBody Book book) {
        Optional<Book> optbook = bookRepository.findById(id);
        Book c = optbook.get();
        if(book.getTitle() != null)
            c.setTitle(book.getTitle());
        if(book.getAuthor() != null)
            c.setAuthor(book.getAuthor());
        if(book.getDescription() != null)
            c.setDescription(book.getDescription());
        if(book.getRating() != null)
            c.setRating(book.getRating());
        bookRepository.save(c);
        return c;
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/books/{id}")
    public String delete(@PathVariable String id) {
        Optional<Book> optbook = bookRepository.findById(id);
        Book book = optbook.get();
        bookRepository.delete(book);

        return "";
    }
}
