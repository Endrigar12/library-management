package pl.library.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.library.library.model.Author;
import pl.library.library.service.AuthorService;

import java.util.List;

@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @RequestMapping("/authors")
    public String listAuthor(Model model) {
        List<Author> authorList = authorService.listAll();
        model.addAttribute("authors", authorList);

//        authorList.add(new Author(1L, "example author1", "example author11"));
//        authorList.add(new Author(2L, "example author2", "example author22"));
        return "author";
    }
}
