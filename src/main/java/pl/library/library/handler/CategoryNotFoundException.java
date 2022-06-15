package pl.library.library.handler;

public class CategoryNotFoundException extends IllegalArgumentException{

    private static final long serialVersionUID = 1L;

    public CategoryNotFoundException(Long id) {
        super(String.format("Category with Id %d not found", id));
    }
}
