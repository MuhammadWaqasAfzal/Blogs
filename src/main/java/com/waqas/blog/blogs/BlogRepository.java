package com.waqas.blog.blogs;

import com.waqas.blog.reponse.ApiResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BlogRepository extends JpaRepository<Blog,Long> {

//    @Query("Select b from Blog b where email=?1")
//    Optional<Blog> findByEmail(String email);

    Optional<List<Blog>> findByUserId(Long userId);

}
