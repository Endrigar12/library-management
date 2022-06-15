package pl.library.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.library.library.handler.PublisherNotFoundException;
import pl.library.library.model.Lend;
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
        return readerRepository.findById(id).orElseThrow(() -> new PublisherNotFoundException(id));
    }

    public void delete(long id) {
        readerRepository.deleteById(id);
    }

    public Page<Reader> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.readerRepository.findAll(pageable);
    }
}
