package xyz.prokosna.springddd.infra.rest.store;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.prokosna.springddd.app.store.StoreApplicationService;
import xyz.prokosna.springddd.domain.model.store.Author;
import xyz.prokosna.springddd.domain.model.store.Book;
import xyz.prokosna.springddd.domain.model.store.BookDetailed;
import xyz.prokosna.springddd.domain.model.store.Publisher;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
public class StoreResource {
  private final StoreApplicationService storeApplicationService;

  public StoreResource(StoreApplicationService storeApplicationService) {
    this.storeApplicationService = storeApplicationService;
  }

  @GetMapping("/init")
  public ResponseEntity<String> init() {
    this.storeApplicationService.init();
    return ResponseEntity.ok().build();
  }

  @GetMapping("/req")
  public List<Map<String, String>> req(
      @RequestHeader Map<String, String> headers, @RequestParam Map<String, String> parameters) {
    return Arrays.asList(headers, parameters);
  }

  @GetMapping("/books")
  public List<Book> getAllBooks() {
    return this.storeApplicationService.getAllBooks();
  }

  @GetMapping("/authors")
  public List<Author> getAllAuthors() {
    return this.storeApplicationService.getAllAuthors();
  }

  @GetMapping("/publishers")
  public List<Publisher> getAllPublishers() {
    return this.storeApplicationService.getAllPublisher();
  }

  @GetMapping("/all")
  public List<BookDetailed> getAllDetailedBooks() {
    return this.storeApplicationService.getAllDetailedBooks();
  }
}
