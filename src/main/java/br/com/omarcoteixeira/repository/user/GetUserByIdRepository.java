package br.com.omarcoteixeira.repository.user;

import br.com.omarcoteixeira.data.model.user.User;

@FunctionalInterface
public interface GetUserByIdRepository {
  User execute(String id);
}
