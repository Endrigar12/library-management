package pl.library.library.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int year_of_release;
    private String description;

    @ManyToOne
    private Author author; // wiele ksiażek ma 1 autora

    @ManyToOne
    private Category category;

    @ManyToOne
    private Publisher publisher;

    @OneToMany(mappedBy = "book")
    private List<Lend> lend;

    public Book(Long id, String title, int year_of_release, String description) {
        this.id = id;
        this.title = title;
        this.year_of_release = year_of_release;
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

    public int getYear_of_release() {
        return year_of_release;
    }

    public void setYear_of_release(int year_of_release) {
        this.year_of_release = year_of_release;
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
        return lend.stream().anyMatch(w->w.getReturn_date() == null);
    }

    public boolean isAfterSuggestedReturnDate(){
        return lend.stream().filter(w->w.getReturn_date() == null).anyMatch(w->w.getSuggested_return_date().before(new Date()));
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year_of_release=" + year_of_release +
                ", description='" + description + '\'' +
                '}';
    }
}
