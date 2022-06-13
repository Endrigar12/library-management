package pl.library.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.library.library.model.Author;
import pl.library.library.model.Lend;
import pl.library.library.model.Publisher;
import pl.library.library.service.PublisherService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @RequestMapping("/publishers")
    public String listPublisher(Model model) {
        List<Publisher> publisherList = publisherService.listAll();
        model.addAttribute("publishers", publisherList);

        return findPaginated(1, "id", "asc", model);
    }

    @RequestMapping("/publisher_new")
    public String addNewPublisher(Model model) {
        Publisher publisher = new Publisher();
        model.addAttribute("publisher", publisher);

        return "publisher_new";
    }

    @RequestMapping(value = "/save_publisher", method = RequestMethod.POST)
    public String savePublisher(@Valid @ModelAttribute("publisher") Publisher publisher, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "publisher_new";
        }
        publisherService.save(publisher);
        return "redirect:/publishers";
    }

    @RequestMapping("/publisher_edit/{id}")
    public ModelAndView editPublisher(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("publisher_edit");
        Publisher publisher = publisherService.get(id);
        mav.addObject("publisher", publisher);
        return mav;
    }

    @RequestMapping("/save_edit_publisher/{id}")
    public String editPublisherSave(@PathVariable("id") long id, @Valid  Publisher publisher, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            publisher.setId(id);
            return "publisher_edit";
        }
        publisherService.save(publisher);
        return "redirect:/publishers";
    }

    @RequestMapping("/publisher_delete/{id}")
    public String deletePublisher(@PathVariable(name = "id") Long id) {
        publisherService.delete(id);
        return "redirect:/publishers";
    }

    @GetMapping("/publishers/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 10;

        Page<Publisher> page = publisherService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Publisher> publisherList = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("publishers", publisherList);
        return "publisher";
    }
}
