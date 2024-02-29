package com.lmw.service.impl;

import com.lmw.entity.Book;
import com.lmw.entity.Borrow;
import com.lmw.mapper.BookMapper;
import com.lmw.service.BookService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Resource
    BookMapper mapper;

    @Override
    public List<Borrow> getBorrowList() {
        return mapper.getBorrowList();
    }

    @Override
    public List<Book> getBookList() {
        return mapper.getBookList();
    }
}
