package br.com.omarcoteixeira.config;

import br.com.omarcoteixeira.repository.user.GetUserByIdRepository;
import br.com.omarcoteixeira.repository.user.GetUserByIdRepositoryMongoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfiguration {

  @Bean
  GetUserByIdRepository getUserByIdRepository() {
    return new GetUserByIdRepositoryMongoImpl();
  }
}
