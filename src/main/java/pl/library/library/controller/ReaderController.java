package pl.library.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.library.library.model.Reader;
import pl.library.library.service.ReaderService;

import java.util.List;

@Controller
public class ReaderController {

    @Autowired
    private ReaderService readerService;

    @RequestMapping("/readers")
    public String listReader(Model model) {
        List<Reader> readerList = readerService.listAll();
        model.addAttribute("readers", readerList);

//        readerList.add(new Reader(1L, "example firstname1", "example surrname1", "123456789", "example@example.com", "adress1", "province1", "postal1"));
//        readerList.add(new Reader(1L, "example firstname2", "example surrname2", "987654321", "example2@example.com", "adress2", "province2", "postal2"));
        return findPaginated(1, "id", "asc", model);
    }

    @RequestMapping("/reader_new")
    public String addNewReader(Model model) {
        Reader reader = new Reader();
        model.addAttribute("reader", reader);

        return "reader_new";
    }

    @RequestMapping(value = "/save_reader", method = RequestMethod.POST)
    public String saveReader(@ModelAttribute("reader") Reader reader) {
        readerService.save(reader);

        return "redirect:/readers";
    }

    @RequestMapping("/reader_edit/{id}")
    public ModelAndView editReader(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("reader_edit");
        Reader reader = readerService.get(id);
        mav.addObject("reader", reader);
        return mav;
    }

    @RequestMapping("/reader_delete/{id}")
    public String deleteReader(@PathVariable(name = "id") Long id) {
        readerService.delete(id);
        return "redirect:/readers";
    }

    @GetMapping("/readers/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 10;

        Page<Reader> page = readerService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Reader> readerList = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("readers", readerList);
        return "reader";
    }
}
