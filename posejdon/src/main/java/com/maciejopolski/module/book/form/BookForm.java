package com.maciejopolski.module.book.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class BookForm {

    @NotNull(message = "Author cannot be null")
    @NotEmpty(message = "Author cannot be empty")
    @Size(min = 3, message = "Author should has min 3 letters")
    private String author;

    @NotNull(message = "Title cannot be null")
    @NotEmpty(message = "Title cannot be empty")
    @Size(min = 3, message = "Title should has min 3 letters")
    private String title;

    private String isbn;
    private String lang;
    private String publisher;

    private List<String> tags;

    private String type;

    public List<String> getTags() {
        return tags;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getLang() {
        return lang;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getType() {
        return type;
    }
}
