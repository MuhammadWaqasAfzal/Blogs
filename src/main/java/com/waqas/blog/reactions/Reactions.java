package com.waqas.blog.reactions;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

import java.io.Serializable;

@Entity
@IdClass(ReactionsId.class)
public class Reactions implements Serializable {

    @Id
    private Long userId;
    @Id
    private Long blogId;

    // 0 for no reaction
    // 1 for like
    // 2 for dislike
    private Integer reaction;


    public Reactions(Long userId, Long blogId, Integer reaction) {
        this.userId = userId;
        this.blogId = blogId;
        this.reaction = reaction;
    }

    public Reactions() {

    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public Integer getReaction() {
        return reaction;
    }

    public void setReaction(Integer reaction) {
        this.reaction = reaction;
    }

    @Override
    public String toString() {
        return "Reactions{" +
                "userId=" + userId +
                ", blogId=" + blogId +
                ", reaction=" + reaction +
                '}';
    }
}
