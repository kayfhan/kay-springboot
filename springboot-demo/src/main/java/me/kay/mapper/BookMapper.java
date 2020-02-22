package me.kay.mapper;

import me.kay.entities.Book;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BookMapper {

    @Select("select *from book where book_id=#{bookId}")
    Book find(Integer bookId);

    @Insert("insert into book(book_name) values(#{book.bookName)")
    Book save(Book book);

    @Update("update book set book_name=#{book.bookName} where book_id=#{book.bookId}")
    Book update(Book book);

    @Delete("delete from book where book_id = #{id}")
    int delete(Integer id);

    @Select("select *from book where book_name=#{bookName}")
    Book getBookByName(String bookName);
}
