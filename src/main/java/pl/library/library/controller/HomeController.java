package pl.library.library.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class HomeController {

    @RequestMapping("/")
    public String welcome() {
        return "index";
    }
}
