package pl.library.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.library.library.model.Author;
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

    @RequestMapping("/category_new")
    public String addNewCategory(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);

        return "category_new";
    }

    @RequestMapping(value = "/save_category", method = RequestMethod.POST)
    public String saveCategory(@ModelAttribute("category") Category category) {
        categoryService.save(category);

        return "redirect:/categories";
    }

    @RequestMapping("/category_edit/{id}")
    public ModelAndView editCategory(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("category_edit");
        Category category = categoryService.get(id);
        mav.addObject("category", category);
        return mav;
    }

    @RequestMapping("/category_delete/{id}")
    public String deleteCategory(@PathVariable(name = "id") Long id) {
        categoryService.delete(id);
        return "redirect:/categories";
    }
}
