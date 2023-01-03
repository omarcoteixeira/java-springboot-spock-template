package br.com.omarcoteixeira.controller;

import br.com.omarcoteixeira.data.dto.user.UserCreateDto;
import br.com.omarcoteixeira.data.mapper.UserMapper;
import br.com.omarcoteixeira.usecase.user.GetUserByIdUseCase;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserController {

  UserMapper userMapper;

  GetUserByIdUseCase getUserByIdUseCase;

  @GetMapping("/{id}")
  UserCreateDto getUserById(@PathVariable String id) {
    var user = getUserByIdUseCase.execute(id);
    return userMapper.toDto(user);
  }
}
