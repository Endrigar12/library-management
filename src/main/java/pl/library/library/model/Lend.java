package pl.library.library.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Lend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lend_date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date lendDate;

    @Column(name = "suggested_return_date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date suggestedReturnDate;

    @Column(name = "return_date", nullable = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date returnDate;

    @ManyToOne
    private Book book; // Jedna książka można wiele razy wypozyczyc

    @ManyToOne
    private Reader reader; // Jeden czytelnik może wiele wypozyczyc

    public Lend(Long id, Date lendDate, Date suggestedReturnDate, Date returnDate) {
        this.id = id;
        this.lendDate = lendDate;
        this.suggestedReturnDate = suggestedReturnDate;
        this.returnDate = returnDate;
    }

    public Lend() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getLendDate() {
        return lendDate;
    }

    public void setLendDate(Date lendDate) {
        this.lendDate = lendDate;
    }

    public Date getSuggestedReturnDate() {
        return suggestedReturnDate;
    }

    public void setSuggestedReturnDate(Date suggestedReturnDate) {
        this.suggestedReturnDate = suggestedReturnDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
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
                ", lendDate=" + lendDate +
                ", suggestedReturnDate=" + suggestedReturnDate +
                ", returnDate=" + returnDate +
                '}';
    }

}
