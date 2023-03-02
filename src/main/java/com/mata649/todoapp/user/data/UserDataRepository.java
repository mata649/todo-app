package com.mata649.todoapp.user.data;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDataRepository extends JpaRepository<UserEntity, Long> {
    public void deleteById(Long id);

    public Optional<UserEntity> findByUsername(String username);

}
