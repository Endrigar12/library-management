package pl.library.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.library.library.model.Lend;

@Repository
public interface LendRepository extends JpaRepository<Lend, Long> {
    Lend findByBookId(Long id);
}
