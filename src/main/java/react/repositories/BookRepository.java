package react.repositories;

import org.springframework.data.repository.CrudRepository;
import react.model.Book;

/**
 * Created by nickstanogias on 15/04/18.
 */
public interface BookRepository extends CrudRepository<Book, String>{

    @Override
    void delete(Book deleted);
}
