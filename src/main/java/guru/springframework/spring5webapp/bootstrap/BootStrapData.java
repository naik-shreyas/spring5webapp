package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric","Evans");
        Book ddd = new Book("Domain Design", "123123");
        Publisher pbl1 = new Publisher("Random", "BNG");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        pbl1.getBooks().add(ddd);
        ddd.getPublishers().add(pbl1);
        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(pbl1);


        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development", "454556");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of books: " +bookRepository.count());
        System.out.println("Number of authors: " +authorRepository.count());
        System.out.println("Number of publishers: " +publisherRepository.count());


    }


}
