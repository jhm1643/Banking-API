package com.homework.banking.service;

import com.homework.banking.dto.request.UserRequest;
import com.homework.banking.entity.User;
import com.homework.banking.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public void saveUser(UserRequest userRequest){
        userRepository.save(User.builder()
                .id(userRequest.getId())
                .name(userRequest.getName())
                .age(userRequest.getAge())
                .createDt(LocalDate.now())
                .build());
    }

    public User findById(Long id){
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }
}
