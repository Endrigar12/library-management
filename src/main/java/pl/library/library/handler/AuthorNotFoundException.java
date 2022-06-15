package pl.library.library.handler;

public class AuthorNotFoundException extends IllegalArgumentException {

    private static final long serialVersionUID = 1L;

    public AuthorNotFoundException(Long id) {
        super(String.format("Author with Id %d not found", id));
    }
}
