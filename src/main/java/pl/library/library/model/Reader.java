package pl.library.library.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Reader {

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

    @Column(name = "phone_number", nullable = false)
    @NotBlank
    @Pattern(regexp="(^$|[0-9]{9})")
    private String phoneNumber;

    @Column(name = "email", nullable = true)
    @NotBlank
    @Email
    private String email;

    @Column(name = "address", nullable = false)
    @NotBlank
    @Size(min=2, max=50)
    private String address;

    @Column(name = "province", nullable = false)
    @NotBlank
    @Size(min=2, max=50)
    private String province;

    @Column(name = "postal_code", nullable = false)
    @NotBlank
    @Pattern(regexp="(^$|[0-9]{2}-[0-9]{3})")
    private String postalCode;


    @OneToMany(mappedBy = "reader", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Lend> lend;

    public Reader(Long id, String firstName, String surname, String phoneNumber, String email, String address, String province, String postalCode) {
        this.id = id;
        this.firstName = firstName;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.province = province;
        this.postalCode = postalCode;
    }

    public Reader() {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", province='" + province + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }

}
