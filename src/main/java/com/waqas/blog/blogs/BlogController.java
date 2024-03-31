package com.waqas.blog.blogs;

import com.waqas.blog.reponse.ApiResponse;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/blogs")
public class BlogController {

    @Autowired
    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<?>> createBlog(@RequestBody Blog blog){
        System.out.println(blog);
        if(blog.getUserId() == null || blog.getUserId().toString().isEmpty()) {
            ApiResponse<Blog> apiResponse = new ApiResponse<>(404,"UserId is required",null);
            return ResponseEntity.status( HttpStatus.valueOf(apiResponse.getStatus())).body(apiResponse);
        }

        ApiResponse<Blog> apiResponse = blogService.createBlog(blog);

        if(apiResponse.getStatus() == HttpStatus.OK.value()){
            return ResponseEntity.ok(apiResponse);
        }else{
            return ResponseEntity.status( HttpStatus.valueOf(apiResponse.getStatus())).body(apiResponse);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<ApiResponse<?>> getAllBlogs(){
        ApiResponse<List<Blog>> apiResponse = blogService.getAllBlogs();
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping("/getUserBlog")
    public ResponseEntity<ApiResponse<?>> getUserBlogs(@RequestBody Blog blog){
        if(blog.getUserId() == null || blog.getUserId() .toString().isEmpty()) {
            ApiResponse<Blog> apiResponse = new ApiResponse<>(404,"UserId is required",null);
            return ResponseEntity.status( HttpStatus.valueOf(apiResponse.getStatus())).body(apiResponse);
        }
        ApiResponse<?> apiResponse = blogService.getUserBlogs(blog.getUserId() );
        return ResponseEntity.ok(apiResponse);

    }

}
