package com.lmw.service.impl;

import com.lmw.entity.Book;
import com.lmw.entity.Borrow;
import com.lmw.mapper.BookMapper;
import com.lmw.service.BookService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookServiceImpl implements BookService {

    @Resource
    BookMapper bookMapper;

    @Override
    public List<Borrow> getBorrowList() {
        return bookMapper.getBorrowList();
    }

    @Override
    public void addBorrow(Borrow borrow) {
        bookMapper.addBorrow(borrow);
    }

    @Override
    public Map<Book, Boolean> getBookList() {
        Set<Integer> set = new HashSet<>();
        this.getBorrowList().forEach(borrow -> set.add(borrow.getBid()));
        Map<Book, Boolean> map = new HashMap<>();
        bookMapper.getBookList().forEach(book -> map.put(book, set.contains(book.getId())));
        return map;
    }

    @Override
    public List<Book> getActiveBookList() {
        Set<Integer> set = new HashSet<>();
        this.getBorrowList().forEach(borrow -> set.add(borrow.getBid()));
        return bookMapper.getBookList()
                .stream()
                .filter(book -> !set.contains(book.getId()))
                .toList();
    }

    @Override
    public void addBook(Book book) {
        bookMapper.addBook(book);
    }

    @Override
    public void deleteBook(int id) {
        bookMapper.deleteBook(id);
    }

    @Override
    public void returnBook(int id) {
        bookMapper.deleteBorrow(id);
    }
}
