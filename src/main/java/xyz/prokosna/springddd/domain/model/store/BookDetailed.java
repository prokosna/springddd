package xyz.prokosna.springddd.domain.model.store;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BookDetailed {
  @Id
  private String id;
  private String isdn;
  private String title;
  private String authorName;
  private String publisherId;
}
