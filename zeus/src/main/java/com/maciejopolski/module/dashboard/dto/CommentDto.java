package com.maciejopolski.module.dashboard.dto;

public class CommentDto {
    private final String author;
    private final String text;
    public CommentDto(String author, String text) {
        this.author = author;
        this.text = text;
    }
    public String getAuthor() {
        return author;
    }
    public String getText() {
        return text;
    }
    @Override
    public String toString() {
        return "CommentDto{" +
                "author='" + author + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}