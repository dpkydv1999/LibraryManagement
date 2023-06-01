package com.deepak.courselibrary.controller;

import com.deepak.courselibrary.entity.Book;
import com.deepak.courselibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public String findAllBooks(Model model){
        List<Book> books = bookService.findAllBooks();
        model.addAttribute("books", "book");
        return "books";

    }
    @GetMapping("/book/{id}")
    public String findBook(@PathVariable Long id,Model model){
        Book book= bookService.findBookById(id);
        model.addAttribute("book", book);
        return "List-book";
    }

    @GetMapping("remove-book/{id}")
    public String deleteBook(@PathVariable Long id,Model model){
        bookService.deleteBook(id);
        model.addAttribute("books", bookService.findAllBooks());
        return "books";
    }

    @GetMapping("/update-book/{id}")
    public String updateBook(@PathVariable Long id,Model model){
        Book book = bookService.findBookById(id);
//        model.addAttribute()
    }
}
