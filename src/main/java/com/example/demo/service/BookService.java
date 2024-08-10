package com.example.demo.service;

import com.example.demo.entitiy.Book;
import com.example.demo.entitiy.Student;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.LibraryCardRepository;

public class BookService {

    private final BookRepository _bookRepository;

    public BookService(BookRepository _bookRepository) {
        this._bookRepository = _bookRepository;
    }

    public void addBook(Book book) {
    }

    public Student getBookById(Long id) {
        return null;
    }
}
