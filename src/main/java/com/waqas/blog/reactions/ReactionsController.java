package com.waqas.blog.reactions;

import com.waqas.blog.reponse.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reaction")
public class ReactionsController {

    @Autowired
    private final ReactionsService reactionsService;
    public ReactionsController(ReactionsService reactionsService) {
        this.reactionsService = reactionsService;
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<?>> createReaction(@RequestBody Reactions reactions){
        ApiResponse<?> response =  reactionsService.createReaction(reactions);

        if (response.getStatus() == HttpStatus.OK.value()){
            return  ResponseEntity.ok(response);
        }else{
            return ResponseEntity.status( HttpStatus.valueOf(response.getStatus())).body(response);

        }
    }

    @PostMapping("/getReactionOfBlog")
    public ResponseEntity<ApiResponse<?>> getReactionOfPost(@RequestBody Reactions reactions){
        ApiResponse<?> response =  reactionsService.getReactionsOfBlog(reactions);
        if (response.getStatus() == HttpStatus.OK.value()){
            return  ResponseEntity.ok(response);
        }else{
            return ResponseEntity.status( HttpStatus.valueOf(response.getStatus())).body(response);

        }
    }
}
