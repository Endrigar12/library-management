package pl.library.library.handler;

public class PublisherNotFoundException extends IllegalArgumentException{

    private static final long serialVersionUID = 1L;

    public PublisherNotFoundException(Long id) {
        super(String.format("Publisher with Id %d not found", id));
    }
}
