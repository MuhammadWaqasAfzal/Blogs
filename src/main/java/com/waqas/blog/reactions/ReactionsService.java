package com.waqas.blog.reactions;

import com.waqas.blog.blogs.BlogRepository;
import com.waqas.blog.reponse.ApiResponse;
import com.waqas.blog.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ReactionsService {

    @Autowired
    private final ReactionsRepository reactionsRepository;

    @Autowired
    private final BlogRepository blogRepository;

    @Autowired
    private final UserRepository userRepository;

    public ReactionsService(ReactionsRepository reactionsRepository, BlogRepository blogRepository, UserRepository userRepository) {
        this.reactionsRepository = reactionsRepository;
        this.blogRepository = blogRepository;
        this.userRepository = userRepository;
    }

    public ApiResponse<?> createReaction(Reactions reactions) {
        ApiResponse<?> apiResponse = checkValidity(reactions,true);
        if (apiResponse.getStatus() == HttpStatus.OK.value()) {
            if (reactions.getReaction() == 1 || reactions.getReaction() == 2 || reactions.getReaction() == 0) {
                return ApiResponse.ok(reactionsRepository.save(reactions));
            } else {
                return ApiResponse.error(404, "Reaction status is required");
            }
        } else {
            return apiResponse;
        }
    }

    public ApiResponse<?> getReactionsOfBlog(Reactions reactions) {
        ApiResponse<?> apiResponse = checkValidity(reactions,false);
        if (apiResponse.getStatus() == HttpStatus.OK.value()) {
            System.out.println(reactions);
            System.out.println(reactionsRepository.findById(new ReactionsId(reactions.getUserId(),reactions.getBlogId())));
            return ApiResponse.ok(reactionsRepository.findReactionsByBlogId(reactions.getBlogId()));
        } else {
            return apiResponse;
        }
    }

    public ApiResponse<?> checkValidity(Reactions reactions,Boolean checkUserId) {
        if (reactions.getBlogId() != null) {
            if (blogRepository.findById(reactions.getBlogId()).isPresent()) {
                if(checkUserId) {
                    if (reactions.getUserId() != null) {
                        if (userRepository.findById(reactions.getUserId()).isPresent()) {
                            return ApiResponse.ok(null);
                        } else {
                            return ApiResponse.error(404, "Invalid User Id");
                        }
                    } else {
                        return ApiResponse.error(404, "User Id is required");
                    }
                }else{
                    return ApiResponse.ok(null);
                }
            } else {
                return ApiResponse.error(404, "Invalid Blog Id");
            }
        } else {
            return ApiResponse.error(404, "Blog Id is required");
        }
    }
}
