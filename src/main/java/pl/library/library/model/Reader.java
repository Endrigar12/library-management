package pl.library.library.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String first_name;
    private String surname;
    private String phone_number;
    private String email;
    private String address; //ulica lub osiedle
    private String province; // wojewodztwo
    private String postal_code; //kod pocztowy

    public Reader(Long id, String first_name, String surname, String phone_number, String email, String address, String province, String postal_code) {
        this.id = id;
        this.first_name = first_name;
        this.surname = surname;
        this.phone_number = phone_number;
        this.email = email;
        this.address = address;
        this.province = province;
        this.postal_code = postal_code;
    }

    public Reader() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
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

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", province='" + province + '\'' +
                ", postal_code='" + postal_code + '\'' +
                '}';
    }

}
