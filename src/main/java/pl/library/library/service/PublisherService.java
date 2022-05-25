package pl.library.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    public Publisher get(long id) {
        return publisherRepository.findById(id).get();
    }
}
