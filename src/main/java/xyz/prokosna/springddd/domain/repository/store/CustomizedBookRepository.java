package xyz.prokosna.springddd.domain.repository.store;

import xyz.prokosna.springddd.domain.model.store.BookDetailed;

import java.util.List;

public interface CustomizedBookRepository {
  List<BookDetailed> findAllDetailedBooks();
}
