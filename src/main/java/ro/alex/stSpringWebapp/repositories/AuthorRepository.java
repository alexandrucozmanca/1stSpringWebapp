package ro.alex.stSpringWebapp.repositories;

import org.springframework.data.repository.CrudRepository;
import ro.alex.stSpringWebapp.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>
{
}
