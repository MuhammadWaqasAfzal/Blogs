package com.waqas.blog.reactions;

import java.io.Serializable;
import java.util.Objects;

public class ReactionsId implements Serializable {
    private Long userId;
    private Long blogId;

    public ReactionsId() {
    }

    public ReactionsId(Long userId, Long blogId) {
        this.userId = userId;
        this.blogId = blogId;
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

    // Getters, setters, hashCode, and equals methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReactionsId that = (ReactionsId) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(blogId, that.blogId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, blogId);
    }
}
