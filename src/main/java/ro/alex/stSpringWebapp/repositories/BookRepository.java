package ro.alex.stSpringWebapp.repositories;

import org.springframework.data.repository.CrudRepository;
import ro.alex.stSpringWebapp.model.Book;

public interface BookRepository extends CrudRepository<Book, Long>
{
}
