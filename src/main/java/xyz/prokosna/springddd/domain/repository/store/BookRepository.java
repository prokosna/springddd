package xyz.prokosna.springddd.domain.repository.store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.prokosna.springddd.domain.model.store.Book;

public interface BookRepository extends JpaRepository<Book, String>, CustomizedBookRepository {
}
