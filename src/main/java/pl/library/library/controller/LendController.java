package pl.library.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.library.library.model.Lend;
import pl.library.library.service.LendService;

import java.util.List;

@Controller
public class LendController {

    @Autowired
    private LendService lendService;

    @RequestMapping("/lends")
    public String listLend(Model model) {
        List<Lend> lendList = lendService.listAll();
        model.addAttribute("lends", lendList);

//        lendList.add(new Lend(1L, "example categoryName1"));
        return "lend";
    }
}
