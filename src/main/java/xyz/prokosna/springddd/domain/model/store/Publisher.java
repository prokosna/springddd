package xyz.prokosna.springddd.domain.model.store;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "publishers")
public class Publisher {
  @Id private String id;
  private String name;
  private String address;
}
