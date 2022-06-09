package pl.library.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public void save(Lend lend) {
        lendRepository.save(lend);
    }

    public Lend get(long id) {
        return lendRepository.findByBookId(id);
    }

    public void delete(long id) {
        lendRepository.deleteById(id);
    }

    public Page<Lend> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.lendRepository.findAll(pageable);
    }

}
