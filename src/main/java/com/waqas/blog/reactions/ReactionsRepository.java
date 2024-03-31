package com.waqas.blog.reactions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ReactionsRepository extends JpaRepository<Reactions, ReactionsId> {

    @Query("select r from Reactions r where r.blogId=?1")
    Optional<List<Reactions>> findReactionsByBlogId(Long blogId);
}
