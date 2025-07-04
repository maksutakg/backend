package com.akgun.guestbook.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/guestbook")
public class UserController {

    
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){

        User saved=userService.save(user);
        return ResponseEntity.ok(saved);

    }

    @GetMapping
    public List<UserResponseDto> getAllUsers(){

        return userService.findAll();

    }

    @GetMapping("/{id}")
    public UserResponseDto getUserByID (@PathVariable Long id){
        return userService.findById(id);
    }

    @GetMapping("/note/{id}")
    public String getNotById (@PathVariable Long id){

       
        return userService.getNoteById(id);

    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id){

        userService.deleteUserById(id);

    }

    @PutMapping("/{id}")
    public User updateUser (@PathVariable Long id,@RequestBody User user){
        User existingUser= userService.findByIdM(id);
        existingUser.setMail(user.getMail());
        existingUser.setUsername(user.getUsername());
        existingUser.setSurname(user.getSurname());
        existingUser.setNote(user.getNote());
        return userService.save(existingUser);

    }

}
