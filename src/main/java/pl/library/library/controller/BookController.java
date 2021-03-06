package pl.library.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.library.library.model.*;
import pl.library.library.service.*;

import javax.validation.Valid;
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

    @Autowired
    private LendService lendService;

    @RequestMapping("/books")
    public String listBook(Model model, @Param("keyword") String keyword) {
        List<Book> bookList = bookService.listAllSearch(keyword);  // wyszukiwanie
        model.addAttribute("books", bookList);
        model.addAttribute("keyword", keyword);

        List<Lend> listLend = lendService.listAll();
        model.addAttribute("listLend", listLend);

//        bookList.add(new Book(1L, "title1", 2021, "example description1"));
//        bookList.add(new Book(2L, "title2", 2022, "example description2"));
        return findPaginated(1, "id", "asc", model);
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
    public String saveBook(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult, Model model) {
        model.addAttribute("book", book);

        List<Author> authors = authorService.listAll(); // wyświetlenie listy autorów
        model.addAttribute("listAuthor", authors);

        List<Category> category = categoryService.listAll();
        model.addAttribute("listCategory", category);

        List<Publisher> publisher = publisherService.listAll();
        model.addAttribute("listPublisher", publisher);
        if (bindingResult.hasErrors()) {
            return "book_new";
        }

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

    @RequestMapping("/save_edit_book/{id}")
    public String editBookSave(@PathVariable("id") long id, @Valid Book book, BindingResult bindingResult, Model model) {
        model.addAttribute("book", book);

        List<Author> authors = authorService.listAll(); // wyświetlenie listy autorów
        model.addAttribute("listAuthor", authors);

        List<Category> category = categoryService.listAll();
        model.addAttribute("listCategory", category);

        List<Publisher> publisher = publisherService.listAll();
        model.addAttribute("listPublisher", publisher);

        if (bindingResult.hasErrors()) {
            book.setId(id);
            return "book_edit";
        }
        bookService.save(book);
        return "redirect:/books";
    }

    @RequestMapping("/book_delete/{id}")
    public String deleteBook(@PathVariable(name = "id") Long id) {
        bookService.delete(id);
        return "redirect:/books";
    }

    @GetMapping("/books/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 10;

        Page<Book> page = bookService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Book> bookList = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("books", bookList);
        return "book";
    }

}
