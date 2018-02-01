package xyz.prokosna.springddd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringdddApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringdddApplication.class, args);
  }
}
