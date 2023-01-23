package br.com.omarcoteixeira.data.dto.user;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreateDto {

  String id;
  String name;
}
