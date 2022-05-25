package pl.library.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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

        publisherList.add(new Publisher(1L, "example publisherName1"));
        publisherList.add(new Publisher(2L, "example publisherName2"));
        return "publisher";
    }
}
