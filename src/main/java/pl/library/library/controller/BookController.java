package pl.library.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.library.library.model.Author;
import pl.library.library.model.Book;
import pl.library.library.model.Category;
import pl.library.library.model.Publisher;
import pl.library.library.service.*;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PublisherService publisherService;

    @RequestMapping("/books")
    public String listBook(Model model) {
        List<Book> bookList = bookService.listAll();
        model.addAttribute("books", bookList);

//        bookList.add(new Book(1L, "title1", 2021, "example description1"));
//        bookList.add(new Book(2L, "title2", 2022, "example description2"));
        return "book";
    }

    @RequestMapping("/book_new")
    public String addNewBook(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);

        List<Author> authors = authorService.listAll(); // wyświetlenie listy autorów
        model.addAttribute("listAuthor", authors);

        List<Category> category = categoryService.listAll();
        model.addAttribute("listCategory", category);

        List<Publisher> publisher = publisherService.listAll();
        model.addAttribute("listPublisher", publisher);

        return "book_new";
    }

    @RequestMapping(value = "/save_book", method = RequestMethod.POST)
    public String saveBook(@ModelAttribute("book") Book book) {
        bookService.save(book);

        return "redirect:/books";
    }

    @RequestMapping("/book_edit/{id}")
    public ModelAndView editBook(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("book_edit");
        Book book = bookService.get(id);
        mav.addObject("book", book);

        List<Author> authors = authorService.listAll(); // wyświetlenie listy autorów
        mav.addObject("listAuthor", authors);

        List<Category> category = categoryService.listAll();
        mav.addObject("listCategory", category);

        List<Publisher> publisher = publisherService.listAll();
        mav.addObject("listPublisher", publisher);
        return mav;
    }

    @RequestMapping("/book_delete/{id}")
    public String deleteBook(@PathVariable(name = "id") Long id) {
        bookService.delete(id);
        return "redirect:/books";
    }
}
