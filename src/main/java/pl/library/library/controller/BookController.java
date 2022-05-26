package pl.library.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.library.library.model.Book;
import pl.library.library.service.*;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/books")
    public String listBook(Model model) {
        List<Book> bookList = bookService.listAll();
        model.addAttribute("books", bookList);

//        bookList.add(new Book(1L, "title1", 2021, "example description1"));
//        bookList.add(new Book(2L, "title2", 2022, "example description2"));
        return "book";
    }
}
