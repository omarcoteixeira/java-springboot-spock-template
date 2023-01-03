package br.com.omarcoteixeira.usecase.user;

import br.com.omarcoteixeira.data.model.user.User;

@FunctionalInterface
public interface GetUserByIdUseCase {
  User execute(String id);
}
