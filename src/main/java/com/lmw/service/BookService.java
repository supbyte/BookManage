package com.lmw.service;

import com.lmw.entity.Book;
import com.lmw.entity.Borrow;

import java.util.List;

public interface BookService {

    List<Borrow> getBorrowList();

    List<Book> getBookList();
}
