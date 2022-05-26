package pl.library.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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
        return "reader";
    }
}
