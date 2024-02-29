package com.lmw.mapper;

import com.lmw.entity.Book;
import com.lmw.entity.Borrow;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookMapper {

    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "sid", property = "sid"),
            @Result(column = "bid", property = "bid"),
            @Result(column = "time", property = "time"),
            @Result(column = "name", property = "studentName"),
            @Result(column = "title", property = "bookName")

    })
    //Java15新特性：文本块
    @Select("""
            select * from borrow left join student on sid= student.id
            left join book on bid = book.id
            """)
    List<Borrow> getBorrowList();

    //NOW()返回当前时间的Date对象
    @Insert("insert into borrow values(null,#{sid},#{bid},NOW())")
    void addBorrow(Borrow borrow);

    @Delete("delete from borrow where id = #{id}")
    void deleteBorrow(int id);

    @Select("select * from book")
    List<Book> getBookList();

    @Delete("delete from book where id=#{id}")
    void deleteBook(int id);

    @Insert("insert into book values(null,#{title},#{desc},#{price})")
    void addBook(Book book);


}
