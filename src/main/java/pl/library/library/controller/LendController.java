package pl.library.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.library.library.model.*;
import pl.library.library.service.BookService;
import pl.library.library.service.LendService;
import pl.library.library.service.ReaderService;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Controller
public class LendController {

    @Autowired
    private LendService lendService;

    @Autowired
    private BookService bookService;

    @Autowired
    private ReaderService readerService;

    @RequestMapping("/lends")
    public String listLend(Model model) {
        List<Lend> lendList = lendService.listAll();
        model.addAttribute("lends", lendList);

//        lendList.add(new Lend(1L, "example categoryName1"));
        return "lend";
    }

    @RequestMapping("/lend_new/{id}")
    public String addNewLend(Model model, @PathVariable(name = "id") Long id) {
        Lend lend = new Lend();
        lend.setLend_date(new Date());

        model.addAttribute("lend", lend);
        model.addAttribute("localDate", LocalDateTime.now());

        List<Reader> reader = readerService.listAll();
        model.addAttribute("listReader", reader);

        List<Book> books = bookService.listAll();
        model.addAttribute("listBook", books);

        Book book = bookService.get(id);
        model.addAttribute("book", book);

        lend.setId(book.getId());
        return "lend_new";
    }

    @RequestMapping(value = "/save_lend", method = RequestMethod.POST)
    public String saveLend(@ModelAttribute("lend") Lend lend) {
        lendService.save(lend);

        return "redirect:/books";
    }


    @RequestMapping("/lend_delete/{id}")
    public String deleteLend(@PathVariable(name = "id") int id) {
        lendService.delete(id);
        return "redirect:/lends";
    }

}
