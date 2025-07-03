package com.akgun.guestbook.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akgun.guestbook.Entity.User;
import com.akgun.guestbook.Exception.NotFoundException;
import com.akgun.guestbook.Repository.UserRepository;

@Service
public class UserService {

    @Autowired
private UserRepository userRepository;

public List<User> findAll(){

    return userRepository.findAll();
}

public User save(User user){

    return userRepository.save(user);

}

public void deleteUserById(Long id){

    userRepository.deleteById(id);

}

public User findById (long id){
    return userRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("User not found with id: " + id));
}

public String getNoteById (long id) {
   User user = userRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("User not found with id: " + id));
     return user.getNote();
    
}


}