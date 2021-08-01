package com.maciejopolski.module.book;


import com.maciejopolski.module.book.dto.BookDto;
import com.maciejopolski.module.book.entity.BookEntity;
import com.maciejopolski.module.book.form.BookForm;
import com.maciejopolski.module.book.mapper.BookMapper;
import com.maciejopolski.module.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BooksRestController {


    @Autowired
    private BookService bookService;


    @GetMapping("/api/book")
    public List<BookDto> getBooks() {
        List<BookEntity> books = bookService.findAll();
        return BookMapper.map(books);
    }

    @GetMapping("/api/book/{id}")
    public BookDto getBook(@PathVariable Long id) {
        BookEntity book = bookService.findOne(id);
        return BookMapper.map(book);
    }

    @PostMapping("/api/book")
    public BookDto newBook(@RequestBody @Valid BookForm form) {
        return bookService.create(form);
    }

    @PutMapping("/api/book/{id}")
    public BookDto updateBooks(@PathVariable Long id,
                               @RequestBody BookEntity booksEntity) {
        BookEntity book = bookService.saveAndFlush(booksEntity.setId(id));
        return BookMapper.map(book);
    }

    @DeleteMapping("/api/book/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
    }
}