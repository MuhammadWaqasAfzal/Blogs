package com.waqas.blog.users;

import com.waqas.blog.reponse.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signUp")
    public ResponseEntity<ApiResponse<User>> signUpUser(@RequestBody User user){
        ApiResponse<User> response = userService.signUpUser(user);
        if (response.getStatus() == HttpStatus.OK.value()) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity
                    .status(HttpStatus.valueOf(response.getStatus()))
                    .body(response);
        }

    }

    @PostMapping("/signIn")
    public ResponseEntity<ApiResponse<User>> signInUser(@RequestBody User user){
        ApiResponse<User> response = userService.signInUser(user);
        if (response.getStatus() == HttpStatus.OK.value()) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity
                    .status(HttpStatus.valueOf(response.getStatus()))
                    .body(response);
        }
    }

}
