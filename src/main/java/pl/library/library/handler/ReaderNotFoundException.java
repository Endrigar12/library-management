package pl.library.library.handler;

public class ReaderNotFoundException extends IllegalArgumentException{

    private static final long serialVersionUID = 1L;

    public ReaderNotFoundException(Long id) {
        super(String.format("Reader with Id %d not found", id));
    }
}
