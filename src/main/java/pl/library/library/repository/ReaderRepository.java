package pl.library.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.library.library.model.Reader;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Long> {
}
