package ro.alex.stSpringWebapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import ro.alex.stSpringWebapp.model.Author;
import ro.alex.stSpringWebapp.model.Book;
import ro.alex.stSpringWebapp.model.Publisher;
import ro.alex.stSpringWebapp.repositories.AuthorRepository;
import ro.alex.stSpringWebapp.repositories.BookRepository;
import ro.alex.stSpringWebapp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>
{
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,
                        PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent)
    {
        initData();
    }

    private void initData()
    {

        // Eric
        Author eric = new Author("Eric", "Evans");

        Publisher harperC = new Publisher("Harper Collins", "Boston");
        publisherRepository.save(harperC);

        Book ddd = new Book("Domain Driven Design","1234");
        ddd.setPublisher(harperC);

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        //Rod
        Author rod = new Author("Rod", "Johnson");
        Publisher worx = new Publisher("Worx", "New York");
        publisherRepository.save(worx);

        Book noEJB = new Book("J2EE Development without EJB", "23444");
        noEJB.setPublisher(worx);

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
