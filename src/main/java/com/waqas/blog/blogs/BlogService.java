package com.waqas.blog.blogs;


import com.waqas.blog.reponse.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService {

    @Autowired
    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public ApiResponse<Blog> createBlog(Blog blog){

        return ApiResponse.ok(blogRepository.save(blog));
    }

    public ApiResponse<List<Blog>> getAllBlogs(){
        return ApiResponse.ok(blogRepository.findAll());
    }

    public  ApiResponse<List<Blog>>  getUserBlogs(Long id){

        Optional<List<Blog>> blogs = blogRepository.findByUserId(id);
        if(blogs.isPresent()){
            if(blogs.get().size()>0)
                return ApiResponse.ok(blogs.get());
            else
                return ApiResponse.error(200,"No blogs found against this user");
        }else {
            return ApiResponse.error(400,"Something went wrong");
        }
    }
}
