package com.mata649.todoapp.user.domain;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mata649.todoapp.user.domain.dto.CreateUserDTO;
import com.mata649.todoapp.user.domain.dto.ResponseUserDTO;
import com.mata649.todoapp.user.domain.dto.UpdatePasswordDTO;
import com.mata649.todoapp.errors.exceptions.ObjectNotFoundException;
import com.mata649.todoapp.errors.exceptions.UsernameAlreadyExistsException;

@Service
@Transactional
public class UserUseCases {

    private UserRepository userRepository;

    @Autowired
    public UserUseCases(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseUserDTO create(CreateUserDTO createUserDTO) {
        User user = createUserDTO.toUser();
        userRepository.findByUsername(user.getUsername()).ifPresent(u -> {
            throw new UsernameAlreadyExistsException();
        });
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        User userCreated = userRepository.create(user);
        return ResponseUserDTO.fromUser(userCreated);
    }


    public ResponseUserDTO updatePassword(UpdatePasswordDTO updatePasswordDTO) {
        User user = updatePasswordDTO.toUser();
        User userFound = userRepository.findById(user.getId())
                .orElseThrow(() -> new ObjectNotFoundException("user does not exist"));
        userFound.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return ResponseUserDTO.fromUser(userRepository.update(userFound));
    }

    public List<ResponseUserDTO> findAll() {
        ArrayList<ResponseUserDTO> userList = new ArrayList<>();
        List<User> usersFound = userRepository.findAll();
        usersFound.forEach(user -> userList.add(ResponseUserDTO.fromUser(user)));
        return userList;
    }

    public ResponseUserDTO findOne(Long id) {
        return ResponseUserDTO
                .fromUser(userRepository.findById(id)
                        .orElseThrow(() -> new ObjectNotFoundException("User does not exist")));
    }
}
