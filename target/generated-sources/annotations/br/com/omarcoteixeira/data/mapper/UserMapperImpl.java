package br.com.omarcoteixeira.data.mapper;

import br.com.omarcoteixeira.data.dto.user.UserCreateDto;
import br.com.omarcoteixeira.data.model.user.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-03T15:12:48+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.4.1 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toModel(UserCreateDto userCreateDto) {
        if ( userCreateDto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.name( userCreateDto.getName() );
        user.id( userCreateDto.getId() );

        return user.build();
    }

    @Override
    public UserCreateDto toDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserCreateDto userCreateDto = new UserCreateDto();

        userCreateDto.setId( user.getId() );
        userCreateDto.setName( user.getName() );

        return userCreateDto;
    }
}
