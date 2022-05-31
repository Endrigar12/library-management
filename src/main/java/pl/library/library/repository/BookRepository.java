package pl.library.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.library.library.model.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT book FROM Book book WHERE book.title LIKE %?1%"
            + " OR book.year_of_release LIKE %?1%"
            + " OR book.description LIKE %?1%"
            + " OR book.author.surname LIKE %?1%"
            + " OR book.author.first_name LIKE %?1%"
            + " OR book.category.name LIKE %?1%"
            + " OR book.publisher.name LIKE %?1%"
            + " OR book.id LIKE %?1%"
    )
    public List<Book> search(String keyword);
}
