package com.maciejopolski.module.book.service;

import com.maciejopolski.module.book.entity.BookType;
import com.maciejopolski.module.book.repository.BookRepository;
import com.maciejopolski.module.book.dto.BookDto;
import com.maciejopolski.module.book.entity.BookDetailsEntity;
import com.maciejopolski.module.book.entity.BookEntity;
import com.maciejopolski.module.book.entity.BookTagEntity;
import com.maciejopolski.module.book.form.BookForm;
import com.maciejopolski.module.book.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public BookEntity findOne(Long id) {
        return bookRepository.findOneById(id);
    }

    public List<BookEntity> findAll() {
        return bookRepository.findAll();
    }

    public BookDto create(BookForm form) {
        BookDetailsEntity details = new BookDetailsEntity()
                .setPublisher(form.getPublisher())
                .setLang(form.getLang())
                .setIsbn(form.getIsbn());
        BookEntity newBook = new BookEntity()
                .setAuthor(form.getAuthor())
                .setTitle(form.getTitle())
                .setType(BookType.safeValueOf(form.getType()))
                .setDetails(details);
        newBook.setTags(createTags(form, newBook));
        return BookMapper.map(
                bookRepository.saveAndFlush(newBook)
        );
    }

    private Set<BookTagEntity> createTags(BookForm form, BookEntity newBook) {
        return form.getTags()
                .stream()
                .map(tagStr -> new BookTagEntity().setValue(tagStr).setBook(newBook))
                .collect(Collectors.toSet());
    }

    public BookEntity saveAndFlush(BookEntity setId) {
        return bookRepository.saveAndFlush(setId);
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}