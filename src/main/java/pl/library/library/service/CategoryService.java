package pl.library.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    public Category get(long id) {
        return categoryRepository.findById(id).get();
    }
}
