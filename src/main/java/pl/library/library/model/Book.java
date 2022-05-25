package pl.library.library.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int year_of_release;
    private String description;

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
