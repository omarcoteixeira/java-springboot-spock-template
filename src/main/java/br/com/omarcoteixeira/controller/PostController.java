package br.com.omarcoteixeira.controller;

import br.com.omarcoteixeira.data.dto.user.UserCreateDto;
import br.com.omarcoteixeira.data.mapper.PostMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("post")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class PostController {

  PostMapper postMapper;

  @GetMapping("/{id}")
  UserCreateDto getPostById(@PathVariable String id) {
    return null;
  }
}
