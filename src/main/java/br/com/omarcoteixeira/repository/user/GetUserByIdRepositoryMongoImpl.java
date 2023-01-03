package br.com.omarcoteixeira.repository.user;

import br.com.omarcoteixeira.data.model.user.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class GetUserByIdRepositoryMongoImpl implements GetUserByIdRepository {

  @Override
  public User execute(String id) {
    return User.builder().id(id).name("Testing").build();
  }
}
