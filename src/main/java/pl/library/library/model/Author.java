package pl.library.library.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    @NotBlank
    @Size(min=2, max=30)
    private String firstName;

    @Column(name = "surname", nullable = false)
    @NotBlank
    @Size(min=2, max=40)
    private String surname;


    @OneToMany(mappedBy = "author")
    private List<Book> book;

    public Author(Long id, String firstName, String surname){
        this.id = id;
        this.firstName = firstName;
        this.surname = surname;
    }

    public Author(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
