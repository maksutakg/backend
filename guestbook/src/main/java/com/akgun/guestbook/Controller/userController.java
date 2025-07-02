package com.akgun.guestbook.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akgun.guestbook.Entity.User;

import com.akgun.guestbook.Service.userService;


@RestController
@RequestMapping("/guestbook")
public class userController {

    private userService userService;

    @GetMapping
    public List<User> getAllUsers(){

        return userService.findAll();

    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){

        User saved=userService.save(user);
        return ResponseEntity.ok(saved);

    }

   
    @DeleteMapping

    public void deleteUserById(@PathVariable Long Id){

        userService.deleteUserById(Id);

    }

}
