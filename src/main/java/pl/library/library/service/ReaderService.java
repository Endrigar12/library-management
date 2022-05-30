package pl.library.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.library.library.model.Reader;
import pl.library.library.repository.ReaderRepository;

import java.util.List;

@Service
public class ReaderService {

    @Autowired
    private ReaderRepository readerRepository;

    public List<Reader> listAll() {
        return readerRepository.findAll();
    }

    public void save(Reader reader) {
        readerRepository.save(reader);
    }

    public Reader get(long id) {
        return readerRepository.findById(id).get();
    }

    public void delete(long id) {
        readerRepository.deleteById(id);
    }
}
