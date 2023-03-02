package com.mata649.todoapp.user.data;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mata649.todoapp.user.domain.User;
import com.mata649.todoapp.user.domain.UserRepository;

@Repository
public class UserRepostiroyImpl implements UserRepository {
    private UserMapper userMapper;
    private UserDataRepository userDataRepository;

    @Autowired
    public UserRepostiroyImpl(UserMapper userMapper, UserDataRepository userDataRepository) {
        this.userMapper = userMapper;
        this.userDataRepository = userDataRepository;
    }

    @Override
    public User create(User user) {
        UserEntity userEntity = userMapper.toUserEntity(user);
        return userMapper.toUser(userDataRepository.save(userEntity));
    }

    @Override
    public User delete(Long id) {
        return null;
        // return userMapper.toUser(userDataRepository.deleteByIdAndReturnUser(id));
    }

    @Override
    public User update(User user) {
        UserEntity userEntity = userMapper.toUserEntity(user);
        userMapper.updateUserEntityFromUser(user, userEntity);
        return userMapper.toUser(userDataRepository.save(userEntity));
    }

    @Override
    public Optional<User> findById(Long id) {
        return userDataRepository.findById(id).map(userE -> userMapper.toUser(userE));
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userDataRepository.findByUsername(username).map(user -> userMapper.toUser(user));
    }

    @Override
    public List<User> findAll() {

        return userMapper.toUsers(userDataRepository.findAll());
    }


}
