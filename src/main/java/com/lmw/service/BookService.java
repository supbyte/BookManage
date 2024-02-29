package com.lmw.service;

import com.lmw.entity.Book;
import com.lmw.entity.Borrow;

import java.util.List;
import java.util.Map;

public interface BookService {

    List<Borrow> getBorrowList();

    void addBorrow(Borrow borrow);

    Map<Book, Boolean> getBookList();

    List<Book> getActiveBookList();

    void returnBook(int id);
}
