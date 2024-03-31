package com.waqas.blog.users;

import com.waqas.blog.reponse.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;


@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public ApiResponse<User> signUpUser(User user){
        if(emailExists(user.getEmail())){
            return ApiResponse.error(HttpStatus.NOT_FOUND.value(),"Account already exist");
        }else {
            return ApiResponse.ok( userRepository.save(user));
        }
    }

    private boolean emailExists(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        return user.isPresent();
    }

    public ApiResponse<User> signInUser(User user)  {
        Optional<User> optionalUser =  userRepository.findByEmail(user.getEmail());
        if(optionalUser.isPresent() && Objects.equals(optionalUser.get().getPassword(), user.getPassword())){
            return ApiResponse.ok(optionalUser.get());
        } else{
            return ApiResponse.error(HttpStatus.NOT_FOUND.value(), "Invalid credentials");
        }
    }
}
