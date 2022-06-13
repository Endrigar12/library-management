package pl.library.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.library.library.model.Category;
import pl.library.library.service.CategoryService;

import javax.validation.Valid;
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
//        return "category";
        return findPaginated(1, "id", "asc", model);
    }

    @RequestMapping("/category_new")
    public String addNewCategory(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);

        return "category_new";
    }

    @RequestMapping(value = "/save_category", method = RequestMethod.POST)
    public String saveCategory(@Valid @ModelAttribute("category") Category category, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "category_new";
        }

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

    @RequestMapping("/save_edit_category/{id}")
    public String editCategorySave(@PathVariable("id") long id, @Valid Category category, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            category.setId(id);
            return "category_edit";
        }
        categoryService.save(category);
        return "redirect:/categories";
    }

    @RequestMapping("/category_delete/{id}")
    public String deleteCategory(@PathVariable(name = "id") Long id) {
        categoryService.delete(id);
        return "redirect:/categories";
    }

    @GetMapping("/categories/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 10;

        Page<Category> page = categoryService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Category> categoryList = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("categories", categoryList);
        return "category";
    }
}
