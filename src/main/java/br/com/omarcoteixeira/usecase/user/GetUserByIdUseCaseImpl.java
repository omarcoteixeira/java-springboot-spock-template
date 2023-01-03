package br.com.omarcoteixeira.usecase.user;

import br.com.omarcoteixeira.data.model.user.User;
import br.com.omarcoteixeira.repository.user.GetUserByIdRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class GetUserByIdUseCaseImpl implements GetUserByIdUseCase {

  GetUserByIdRepository getUserByIdRepository;

  @Override
  public User execute(String id) {
    log.debug("Getting user by id: {}", id);
    return getUserByIdRepository.execute(id);
  }
}
