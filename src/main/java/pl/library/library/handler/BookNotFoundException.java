package pl.library.library.handler;

public class BookNotFoundException extends IllegalArgumentException{

    private static final long serialVersionUID = 1L;

    public BookNotFoundException(Long id) {
        super(String.format("Book with Id %d not found", id));
    }
}
