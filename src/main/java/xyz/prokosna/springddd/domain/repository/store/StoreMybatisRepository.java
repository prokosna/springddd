package xyz.prokosna.springddd.domain.repository.store;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import xyz.prokosna.springddd.domain.model.store.BookDetailed;

import java.util.List;

@Mapper
public interface StoreMybatisRepository {
  @Select(
      "SELECT "
          + "a.id as id, "
          + "a.isdn as isdn, "
          + "a.title as title, "
          + "b.name as author_name, "
          + "c.id as publisher_id "
          + "FROM books a "
          + "LEFT JOIN authors b ON a.author_id = b.author_id "
          + "LEFT JOIN publishers c ON a.publisher_name = c.name")
  List<BookDetailed> findAll();
}
