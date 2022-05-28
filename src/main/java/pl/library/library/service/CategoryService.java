package pl.library.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.library.library.model.Author;
import pl.library.library.model.Category;
import pl.library.library.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> listAll() {
        return categoryRepository.findAll();
    }

    public void save(Category category) {
        categoryRepository.save(category);
    }

    public Category get(long id) {
        return categoryRepository.findById(id).get();
    }

    public void delete(long id) {
        categoryRepository.deleteById(id);
    }
}
