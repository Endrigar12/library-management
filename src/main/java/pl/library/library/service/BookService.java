package pl.library.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.library.library.model.Book;
import pl.library.library.repository.BookRepository;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> listAll() {
        return bookRepository.findAll();
    }

    public List<Book> listAll(String keyword) {
        if (keyword != null) {
            return bookRepository.search(keyword);
        }
        return bookRepository.findAll();
    }

    public void save(Book book) {
        bookRepository.save(book);
    }

    public Book get(long id) {
        return bookRepository.findById(id).get();
    }

    public void delete(long id) {
        bookRepository.deleteById(id);
    }

}
