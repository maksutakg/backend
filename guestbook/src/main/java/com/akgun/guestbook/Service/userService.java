package com.akgun.guestbook.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.akgun.guestbook.Entity.User;
import com.akgun.guestbook.Repository.userRepository;

@Service
public class userService {

private userRepository userRepository;

public List<User> findAll(){

    return userRepository.findAll();
}

public User save(@RequestBody User user){

    return userRepository.save(user);

}

public void deleteUserById(Long id){

    userRepository.deleteById(id);

}

}
