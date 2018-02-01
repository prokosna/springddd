package xyz.prokosna.springddd.domain.model.store;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//@SqlResultSetMapping(
//  name = "Book.BookDetailed",
//  classes = {
//    @ConstructorResult(
//      targetClass = xyz.prokosna.springddd.domain.model.store.BookDetailed.class,
//      columns = {
//        @ColumnResult(name = "id", type = String.class),
//        @ColumnResult(name = "isdn", type = String.class),
//        @ColumnResult(name = "title", type = String.class),
//        @ColumnResult(name = "author_name", type = String.class),
//        @ColumnResult(name = "publisher_id", type = String.class)
//      }
//    )
//  }
//)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class Book {
  @Id private String id;
  private String isdn;
  private String title;
  private Long authorId;
  private String publisherName;
}
