package pl.library.library.handler;

public class LendNotFoundException extends IllegalArgumentException{

    private static final long serialVersionUID = 1L;

    public LendNotFoundException(Long id) {
        super(String.format("Lend with Id %d not found", id));
    }
}
