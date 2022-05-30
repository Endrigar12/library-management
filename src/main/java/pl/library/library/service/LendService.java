package pl.library.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.library.library.model.Lend;
import pl.library.library.repository.LendRepository;

import java.util.List;

@Service
public class LendService {

    @Autowired
    private LendRepository lendRepository;

    public List<Lend> listAll() {
        return lendRepository.findAll();
    }

    public Lend get(long id) {
        return lendRepository.findById(id).get();
    }

    public void delete(long id) {
        lendRepository.deleteById(id);
    }
}
