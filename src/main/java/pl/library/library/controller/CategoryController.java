package pl.library.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.library.library.model.Category;
import pl.library.library.service.CategoryService;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/categories")
    public String listCategory(Model model) {
        List<Category> categoryList = categoryService.listAll();
        model.addAttribute("categories", categoryList);

//        categoryList.add(new Category(1L, "example categoryName1"));
//        categoryList.add(new Category(2L, "example categoryName2"));
        return "category";
    }
}
