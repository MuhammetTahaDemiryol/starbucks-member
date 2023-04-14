package com.starbucks.starbucks.api.controller;

import com.starbucks.starbucks.service.abstracts.UserService;
import com.starbucks.starbucks.service.dto.request.CreateUserRequest;
import com.starbucks.starbucks.service.dto.request.UpdateUserRequest;
import com.starbucks.starbucks.service.dto.response.CreateUserResponse;
import com.starbucks.starbucks.service.dto.response.GetAllUsersResponse;
import com.starbucks.starbucks.service.dto.response.GetUserResponse;
import com.starbucks.starbucks.service.dto.response.UpdateUserResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public ResponseEntity<List<GetAllUsersResponse>> getAllUsers(){
        return new ResponseEntity<>(userService.getALl(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<GetUserResponse> getUserById(@PathVariable int id){
        return new ResponseEntity<>(userService.getUserById(id),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<CreateUserResponse> saveUser(@Valid@RequestBody CreateUserRequest userRequest) throws Exception{
        return new ResponseEntity<>(userService.saveUser(userRequest),HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        userService.deleteUser(id);
        return new ResponseEntity<>("Kullanici Silindi",HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<UpdateUserResponse> updateUser(@PathVariable int id,
                                                         @Valid@RequestBody UpdateUserRequest updateUserRequest){
        return new ResponseEntity<>(userService.updateUser(id,updateUserRequest),HttpStatus.OK);
    }
}