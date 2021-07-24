package com.maciejopolski.module.dashboard.dto;

import java.util.List;
public class ArticleDto {
    private String title;
    private String description;
    private List<CommentDto> comments;
    public String getTitle() {
        return title;
    }
    public ArticleDto setTitle(String title) {
        this.title = title;
        return this;
    }
    public String getDescription() {
        return description;
    }
    public ArticleDto setDescription(String description) {
        this.description = description;
        return this;
    }
    public List<CommentDto> getComments() {
        return comments;
    }
    public ArticleDto setComments(List<CommentDto> comments) {
        this.comments = comments;
        return this;
    }
    @Override
    public String toString() {
        return "ArticleDto{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", comments=" + comments +
                '}';
    }
}