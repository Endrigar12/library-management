package pl.library.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.library.library.handler.PublisherNotFoundException;
import pl.library.library.model.Publisher;
import pl.library.library.repository.PublisherRepository;

import java.util.List;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    public List<Publisher> listAll() {
        return publisherRepository.findAll();
    }

    public void save(Publisher publisher) {
        publisherRepository.save(publisher);
    }

    public Publisher get(long id) {
        return publisherRepository.findById(id).orElseThrow(() -> new PublisherNotFoundException(id));
    }

    public void delete(long id) {
        publisherRepository.deleteById(id);
    }

    public Page<Publisher> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.publisherRepository.findAll(pageable);
    }

}
