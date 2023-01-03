package br.com.omarcoteixeira.config;

import br.com.omarcoteixeira.repository.user.GetUserByIdRepository;
import br.com.omarcoteixeira.usecase.user.GetUserByIdUseCase;
import br.com.omarcoteixeira.usecase.user.GetUserByIdUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {

  @Bean
  GetUserByIdUseCase getUserByIdUseCase(GetUserByIdRepository getUserByIdRepository) {
    return new GetUserByIdUseCaseImpl(getUserByIdRepository);
  }
}
