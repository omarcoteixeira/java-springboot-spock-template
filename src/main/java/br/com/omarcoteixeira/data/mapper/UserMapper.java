package br.com.omarcoteixeira.data.mapper;

import br.com.omarcoteixeira.data.dto.user.UserCreateDto;
import br.com.omarcoteixeira.data.model.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    uses = {BaseMapper.class})
public interface UserMapper {

  @Mapping(source = "name", target = "name")
  User toModel(UserCreateDto userCreateDto);

  @Mapping(source = "id", target = "id")
  @Mapping(source = "name", target = "name")
  UserCreateDto toDto(User user);
}
