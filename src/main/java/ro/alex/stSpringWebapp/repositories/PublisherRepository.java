package ro.alex.stSpringWebapp.repositories;

import org.springframework.data.repository.CrudRepository;
import ro.alex.stSpringWebapp.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
