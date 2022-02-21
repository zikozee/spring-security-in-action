package com.zikozee.prepostauthorization.controller;

import com.zikozee.prepostauthorization.model.Employee;
import com.zikozee.prepostauthorization.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Ezekiel Eromosei
 * @created : 21 Feb, 2022
 */

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(path = "book/details/{name}")
    public Employee getDetails(@PathVariable(value = "name") String name){
        return bookService.getBookDetails(name);
    }
}
