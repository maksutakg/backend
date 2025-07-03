package com.akgun.guestbook.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akgun.guestbook.Entity.User;

import com.akgun.guestbook.Service.UserService;


@RestController
@RequestMapping("/guestbook")
public class UserController {

    
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers(){

        return userService.findAll();

    }

    

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserByID(@PathVariable Long id){
        User user= userService.findById(id);
        if(user==null){
            return ResponseEntity.notFound().build();
        }
        else{
            return ResponseEntity.ok(user);
        }
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
    public ResponseEntity<String> getNotById (@PathVariable Long id){

        if (userService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        else {
            String note = userService.getNoteById(id);
            return ResponseEntity.ok(note);
        }
       


    }

}
