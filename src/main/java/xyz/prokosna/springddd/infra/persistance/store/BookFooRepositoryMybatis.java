package xyz.prokosna.springddd.infra.persistance.store;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import xyz.prokosna.springddd.domain.model.store.Book;
import xyz.prokosna.springddd.domain.repository.store.BookFooRepository;

@Repository
public class BookFooRepositoryMybatis implements BookFooRepository {

  private final SqlSession sqlSession;

  public BookFooRepositoryMybatis(SqlSession sqlSession) {
    this.sqlSession = sqlSession;
  }

  @Override
  public Book findById(String id) {
    return sqlSession.selectOne("findById", id);
  }
}
