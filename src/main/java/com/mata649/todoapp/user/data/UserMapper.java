package com.mata649.todoapp.user.data;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.mata649.todoapp.user.domain.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "username", target = "username"),
            @Mapping(source = "password", target = "password"),
    })
    public User toUser(UserEntity userEntity);

    public List<User> toUsers(List<UserEntity> users);

    @InheritInverseConfiguration
    @Mapping(target = "todos", ignore = true)
    public UserEntity toUserEntity(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "todos", ignore = true)
    public void updateUserEntityFromUser(User user, @MappingTarget UserEntity userEntity);
}
