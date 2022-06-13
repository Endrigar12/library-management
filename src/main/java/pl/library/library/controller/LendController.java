package pl.library.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.library.library.model.*;
import pl.library.library.service.BookService;
import pl.library.library.service.LendService;
import pl.library.library.service.ReaderService;

import javax.validation.Valid;
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
        return findPaginated(1, "id", "asc", model);
    }

    @RequestMapping("/lend_new/{id}")
    public String addNewLend(Model model, @PathVariable(name = "id") Long id) {
        Lend lend = new Lend();
        lend.setLendDate(new Date());

        model.addAttribute("lend", lend);
        model.addAttribute("localDate", LocalDateTime.now());

        List<Reader> reader = readerService.listAll();
        model.addAttribute("listReader", reader);

        List<Book> books = bookService.listAll();
        model.addAttribute("listBook", books);

        Book book = bookService.get(id);
        model.addAttribute("book", book);

        return "lend_new";
    }

    @RequestMapping(value = "/save_lend", method = RequestMethod.POST)
    public String saveLend(@Valid @ModelAttribute("lend") Lend lend, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "lend_new";
        }
        lendService.save(lend);
        return "redirect:/books";
    }

    @RequestMapping("/lend_edit/{id}")
    public ModelAndView editLend(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("lend_edit");

        Lend lend = lendService.get(id);
        mav.addObject("lend", lend);

        List<Book> books = bookService.listAll();
        mav.addObject("listBook", books);

        Book book = bookService.get(id);
        mav.addObject("book", book);

        List<Reader> reader = readerService.listAll();
        mav.addObject("listReader", reader);

        lend.setReturnDate(new Date());
        return mav;
    }

    @RequestMapping("/save_edit_lend/{id}")
    public String saveEditLend(@PathVariable("id") long id, @Valid  Lend lend, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            lend.setId(id);
            return "lend_edit";
        }
        lendService.save(lend);
        return "redirect:/lends";
    }

    @RequestMapping("/lend_delete/{id}")
    public String deleteLend(@PathVariable(name = "id") int id) {
        lendService.delete(id);
        return "redirect:/lends";
    }

    @GetMapping("/lends/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 10;

        Page<Lend> page = lendService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Lend> lendList = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("lends", lendList);
        return "lend";
    }
}
