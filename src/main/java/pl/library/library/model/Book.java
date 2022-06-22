package pl.library.library.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    @NotBlank
    @Size(min=2, max=100)
    private String title;

    @Column(name = "year_of_release", nullable = false)
    private int yearOfRelease;

    @Column(name = "description", nullable = true)
    @Size(max=300)
    private String description;

    @ManyToOne
    private Author author; // wiele ksiażek ma 1 autora

    @ManyToOne
    private Category category;

    @ManyToOne
    private Publisher publisher;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Lend> lend;

    public Book(Long id, String title, int yearOfRelease, String description) {
        this.id = id;
        this.title = title;
        this.yearOfRelease = yearOfRelease;
        this.description = description;
    }

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public List<Lend> getLend() {
        return lend;
    }

    public void setLend(List<Lend> lend) {
        this.lend = lend;
    }

    public boolean isLend() {
        return lend.stream().anyMatch(w->w.getReturnDate() == null);
    }

    public boolean isAfterSuggestedReturnDate(){
        return lend.stream().filter(w->w.getReturnDate() == null).anyMatch(w->w.getSuggestedReturnDate().before(new Date()));
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", yearOfRelease=" + yearOfRelease +
                ", description='" + description + '\'' +
                '}';
    }
}
