package pl.library.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.library.library.model.Publisher;
import pl.library.library.service.PublisherService;

import java.util.List;

@Controller
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @RequestMapping("/publishers")
    public String listPublisher(Model model) {
        List<Publisher> publisherList = publisherService.listAll();
        model.addAttribute("publishers", publisherList);

//        publisherList.add(new Publisher(1L, "example publisherName1"));
//        publisherList.add(new Publisher(2L, "example publisherName2"));
        return "publisher";
    }

    @RequestMapping("/publisher_new")
    public String addNewPublisher(Model model) {
        Publisher publisher = new Publisher();
        model.addAttribute("publisher", publisher);

        return "publisher_new";
    }

    @RequestMapping(value = "/save_publisher", method = RequestMethod.POST)
    public String savePublisher(@ModelAttribute("publisher") Publisher publisher) {
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

    @RequestMapping("/publisher_delete/{id}")
    public String deletePublisher(@PathVariable(name = "id") Long id) {
        publisherService.delete(id);
        return "redirect:/publishers";
    }
}
