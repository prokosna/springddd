package xyz.prokosna.springddd.infra.persistance.store;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import xyz.prokosna.springddd.domain.model.store.BookDetailed;
import xyz.prokosna.springddd.domain.repository.store.CustomizedBookRepository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class BookRepositoryImpl implements CustomizedBookRepository {

  private final EntityManager entityManager;

  public BookRepositoryImpl(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @SuppressWarnings("unchecked")
  @Cacheable("findAllDetailedBooks")
  public List<BookDetailed> findAllDetailedBooks() {
    return entityManager
        .createNativeQuery(
            "SELECT a.id, "
                + "a.isdn, "
                + "a.title, "
                + "b.name as author_name, "
                + "c.id as publisher_id "
                + "from books a "
                + "left join authors b on a.author_id = b.author_id "
                + "left join publishers c on a.publisher_name = c.name",
            BookDetailed.class)
        .getResultList();
  }
}
