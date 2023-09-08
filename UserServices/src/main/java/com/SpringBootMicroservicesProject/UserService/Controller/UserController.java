package com.SpringBootMicroservicesProject.UserService.Controller;

import com.SpringBootMicroservicesProject.UserService.Exception.ResourceNotFoundException;
import com.SpringBootMicroservicesProject.UserService.Model.User;
import com.SpringBootMicroservicesProject.UserService.Service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController
{
    @Autowired
    private userService userservice;
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user)
    {

            User user1 = userservice.saveUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).build();

    }
    @GetMapping
    public ResponseEntity<List<User>> GetAllUser()
    {
        List<User> users=userservice.getAllUser();
        return ResponseEntity.ok(users);
    }
    @GetMapping("/{userId}")
    public ResponseEntity<User> GetOneUser(@PathVariable String userId)
    {
        User user=userservice.getUser(userId);
        return ResponseEntity.ok(user);
    }
}
