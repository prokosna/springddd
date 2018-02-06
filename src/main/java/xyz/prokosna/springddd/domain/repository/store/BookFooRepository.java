package xyz.prokosna.springddd.domain.repository.store;

import xyz.prokosna.springddd.domain.model.store.Book;

public interface BookFooRepository {
  Book findById(String id);
}
