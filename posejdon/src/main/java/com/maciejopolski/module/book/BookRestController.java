package com.maciejopolski.module.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import javax.validation.Valid;
import java.util.List;

@RestController
public class BookRestController {

//    private static final List<BookEntity> BOOK_ENTITIES = List.of(
//            new BookEntity().setId(1L).setTitle("Lorem 1").setAuthor("Author 1"),
//            new BookEntity().setId(2L).setTitle("Lorem 2").setAuthor("Author 2"),
//            new BookEntity().setId(3L).setTitle("Lorem 3").setAuthor("Author 3")
//    );

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/api/book")
    public List<BookEntity> getBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/api/book/{id}")
    public BookEntity getBook(@PathVariable Long id) {
        return bookRepository.findOneById(id);
    }

    @PostMapping("/api/book")
    public BookEntity newBooks(@RequestBody @Valid BookEntity bookEntity){
        return bookRepository.saveAndFlush(bookEntity);
    }

    @DeleteMapping("/api/book/{id}")
    public void deleteBooks(@PathVariable Long id){
        bookRepository.deleteById(id);
    }

    @PutMapping("/api/book/{id}")
    public BookEntity updateBooks(@PathVariable Long id,
    @RequestBody BookEntity booksEntity){
        return bookRepository.saveAndFlush(booksEntity.setId(id));
    }
}
