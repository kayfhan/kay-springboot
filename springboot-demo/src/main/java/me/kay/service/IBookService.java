package me.kay.service;

import me.kay.entities.Book;

public interface IBookService {
    Book getBookById(Integer id);
    Book updateBook(Book book);
    int deleteBook(Integer id);
    Book saveBook(Book book);
}
