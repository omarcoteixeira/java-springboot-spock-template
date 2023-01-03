package br.com.omarcoteixeira.data.model.post;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum PostStatusEnum {
  DRAFT(0),
  PUBLISHED(1),
  ARCHIVED(2);

  Integer code;
}
