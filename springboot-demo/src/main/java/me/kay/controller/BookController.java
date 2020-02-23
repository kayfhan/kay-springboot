package me.kay.controller;

import me.kay.entities.Book;
import me.kay.service.IBookService;
import me.kay.utils.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    IBookService bookService;

    @GetMapping(value = "/book/{id}")
    public Book allPet(@PathVariable("id") int id){
        return bookService.getBookById(id);
    }

    @GetMapping(value = "/send_mail")
    public boolean sendMail(){
        return MailUtil.sendMail(
                "kayfhan@sina.com",
                "hello kay",
                "you are a handsome boy.",
                "601400175@qq.com");
    }
}
