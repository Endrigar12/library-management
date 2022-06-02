package pl.library.library.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Lend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date lend_date;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date suggested_return_date;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date return_date;

    @ManyToOne
    private Book book; // Jedna książka można wiele razy wypozyczyc

    @ManyToOne
    private Reader reader; // Jeden czytelnik może wiele wypozyczyc

    public Lend(Long id, Date lend_date, Date suggested_return_date, Date return_date) {
        this.id = id;
        this.lend_date = lend_date;
        this.suggested_return_date = suggested_return_date;
        this.return_date = return_date;
    }

    public Lend() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getLend_date() {
        return lend_date;
    }

    public void setLend_date(Date lend_date) {
        this.lend_date = lend_date;
    }

    public Date getSuggested_return_date() {
        return suggested_return_date;
    }

    public void setSuggested_return_date(Date suggested_return_date) {
        this.suggested_return_date = suggested_return_date;
    }

    public Date getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    @Override
    public String toString() {
        return "Lend{" +
                "id=" + id +
                ", lend_date=" + lend_date +
                ", suggested_return_date=" + suggested_return_date +
                ", return_date=" + return_date +
                '}';
    }

}
