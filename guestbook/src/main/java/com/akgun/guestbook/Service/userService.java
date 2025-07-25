package com.akgun.guestbook.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.akgun.guestbook.Entity.User;
import com.akgun.guestbook.Entity.dto.UserResponseDto;
import com.akgun.guestbook.Exception.NotFoundException;
import com.akgun.guestbook.Repository.UserRepository;

@Service
public class UserService {

    @Autowired
private UserRepository userRepository;

public List<UserResponseDto> findAll(){

    return userRepository.findAll().stream().map(user->
        new UserResponseDto(user.getId(), user.getUsername(),user.getSurname(),user.getNote()))
        .toList();
}

public User save(User user){

    return userRepository.save(user);

}

public void deleteUserById(Long id){

    userRepository.deleteById(id);

}
public User findByIdM (long id){
  
    return userRepository.findById(id) .orElseThrow(() -> new NotFoundException("User not found with id: " + id));

        
}

public UserResponseDto findById (long id){
  
    return userRepository.findById(id)
        .map(user -> new UserResponseDto(user.getId(), user.getUsername(), user.getNote(),user.getSurname()))
        .orElseThrow(() -> new NotFoundException("User not found with id: " + id));

        
}

public String getNoteById (long id) {
   User user = userRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("User not found with id: " + id));
     return user.getNote();
    
}
public User UserpdateUser (long id,User user){

   User existingUser = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found with id: " + id));
   existingUser.setMail(user.getMail());
   existingUser.setUsername(user.getUsername());
   existingUser.setSurname(user.getSurname());
   existingUser.setNote(user.getNote());
   return userRepository.save(user);


}


}