package com.akgun.guestbook.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akgun.guestbook.Entity.User;
import com.akgun.guestbook.Entity.dto.UserResponseDto;
import com.akgun.guestbook.Service.UserService;


@RestController
@RequestMapping("/guestbook")
public class UserController {

    
    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserResponseDto> getAllUsers(){

        return userService.findAll();

    }


    @GetMapping("/{id}")
    public UserResponseDto getUserByID (@PathVariable Long id){
        return userService.findById(id);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){

        User saved=userService.save(user);
        return ResponseEntity.ok(saved);

    }

   
    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id){

        userService.deleteUserById(id);

    }

    @GetMapping("/note/{id}")
    public String getNotById (@PathVariable Long id){

       
        return userService.getNoteById(id);

    }

    @PutMapping("/{id}")
    public User updateNote (@PathVariable Long id,@RequestBody User user){

        User existingUser = userService.findByIdM(id);
        existingUser.setNote(user.getNote());
        return userService.save(existingUser);

    }

}
