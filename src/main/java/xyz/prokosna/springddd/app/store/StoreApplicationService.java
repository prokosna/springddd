package xyz.prokosna.springddd.app.store;

import com.codahale.metrics.annotation.Metered;
import com.codahale.metrics.annotation.Timed;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.prokosna.springddd.domain.model.store.Author;
import xyz.prokosna.springddd.domain.model.store.Book;
import xyz.prokosna.springddd.domain.model.store.BookDetailed;
import xyz.prokosna.springddd.domain.model.store.Publisher;
import xyz.prokosna.springddd.domain.repository.store.AuthorRepository;
import xyz.prokosna.springddd.domain.repository.store.BookRepository;
import xyz.prokosna.springddd.domain.repository.store.PublisherRepository;
import xyz.prokosna.springddd.domain.repository.store.StoreMybatisRepository;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class StoreApplicationService {

  private final AuthorRepository authorRepository;
  private final BookRepository bookRepository;
  private final PublisherRepository publisherRepository;
  private final StoreMybatisRepository storeMybatisRepository;

  public StoreApplicationService(
      AuthorRepository authorRepository,
      BookRepository bookRepository,
      PublisherRepository publisherRepository,
      StoreMybatisRepository storeMybatisRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
    this.publisherRepository = publisherRepository;
    this.storeMybatisRepository = storeMybatisRepository;
  }

  @Transactional
  public void init() {
    val book1 = new Book("a", "isdn1", "book1", 1L, "kodansha");
    val book2 = new Book("b", "isdn2", "book2", 2L, "shueisha");
    val book3 = new Book("c", "isdn3", "book3", 3L, "kadokawa");
    bookRepository.save(Arrays.asList(book1, book2, book3));

    val author1 =
        new Author(
            1L,
            "author1",
            Date.from(
                ZonedDateTime.of(LocalDateTime.of(1990, 10, 5, 0, 0, 0), ZoneId.systemDefault())
                    .toInstant()));
    val author2 =
        new Author(
            2L,
            "author2",
            Date.from(
                ZonedDateTime.of(LocalDateTime.of(1903, 2, 3, 2, 3, 4), ZoneId.systemDefault())
                    .toInstant()));
    val author3 =
        new Author(
            3L,
            "author3",
            Date.from(
                ZonedDateTime.of(1998, 12, 31, 0, 0, 0, 0, ZoneId.systemDefault()).toInstant()));
    authorRepository.save(Arrays.asList(author1, author2, author3));

    val publisher1 = new Publisher("A", "kodansha", "新川");
    val publisher2 = new Publisher("B", "shueisha", "銀座");
    val publisher3 = new Publisher("C", "kadokawa", "池袋");
    publisherRepository.save(Arrays.asList(publisher1, publisher2, publisher3));
  }

  public List<Book> getAllBooks() {
    return bookRepository.findAll();
  }

  public List<Author> getAllAuthors() {
    return authorRepository.findAll();
  }

  public List<Publisher> getAllPublisher() {
    return publisherRepository.findAll();
  }

  @Metered
  public List<BookDetailed> getAllDetailedBooks() {
    // return storeMybatisRepository.findAll();
    return bookRepository.findAllDetailedBooks();
  }
}
