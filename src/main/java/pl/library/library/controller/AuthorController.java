package pl.library.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
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
//        return "author";
        return findPaginated(1, "id", "asc", model);
    }

    @RequestMapping("/author_new")
    public String addNewAuthor(Model model) {
        Author author = new Author();
        model.addAttribute("author", author);

        return "author_new";
    }

    @RequestMapping(value = "/save_author", method = RequestMethod.POST)
    public String saveAuthor(@ModelAttribute("author") Author author) {
        authorService.save(author);

        return "redirect:/authors";
    }

    @RequestMapping("/author_edit/{id}")
    public ModelAndView editAuthor(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("author_edit");
        Author author = authorService.get(id);
        mav.addObject("author", author);
        return mav;
    }

    @RequestMapping("/author_delete/{id}")
    public String deleteAuthor(@PathVariable(name = "id") Long id) {
        authorService.delete(id);
        return "redirect:/authors";
    }

    @GetMapping("/authors/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 10;

        Page<Author> page = authorService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Author> authorList = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("authors", authorList);
        return "author";
    }
}
