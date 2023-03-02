package com.mata649.todoapp.user.domain;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    public User create(User user);

    public Optional<User> findById(Long id);

    public Optional<User> findByUsername(String username);

    public List<User> findAll();

    public User delete(Long id);

    public User update(User user);
}
