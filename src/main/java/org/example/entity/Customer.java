package org.example.entity;

import org.example.util.Gender;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;
    private String city;
    @Column(name="company_name")
    private String companyName;
    private String country;
    private String email;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    private String phone;
    @Column(name="zip_code")
    private String zipCode;
    private Integer state;
    private Gender gender; // 0:MALE / 1:FEMALE / 2:OTHER



    @OneToOne
    @JoinColumn(name="payment_id")
    private Payment payment; // numéro de Carte bleu

    @ManyToOne
    @JoinColumn(name="delivery_address_id")
    private Address deliveryAddress; // 1 seule adresse par Customer

    @ManyToMany
    private List<Product> products = new ArrayList<>();

    public Customer(){
    }
    public Customer(String firstName){
        this.firstName = firstName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product){
        this.products.add(product);
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setNotNullData(Customer newCustomerData){
        if(newCustomerData.getFirstName() != null) {
            this.setFirstName(newCustomerData.getFirstName());
        }

        if(newCustomerData.getLastName() != null) {
            this.setLastName(newCustomerData.getLastName());
        }

        if(newCustomerData.getAddress() != null) {
            this.setAddress(newCustomerData.getAddress());
        }

        if(newCustomerData.getCity() != null) {
            this.setCity(newCustomerData.getCity());
        }

        if(newCustomerData.getCountry() != null) {
            this.setCountry(newCustomerData.getCountry());
        }

        if(newCustomerData.getCompanyName() != null) {
            this.setCompanyName(newCustomerData.getCompanyName());
        }

        if(newCustomerData.getPhone() != null) {
            this.setPhone(newCustomerData.getPhone());
        }

        if(newCustomerData.getZipCode() != null) {
            this.setZipCode(newCustomerData.getZipCode());
        }

        if(newCustomerData.getEmail() != null) {
            this.setEmail(newCustomerData.getEmail());
        }

        if(newCustomerData.getState() != null) {
            this.setState(newCustomerData.getState());
        }
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", companyName='" + companyName + '\'' +
                ", country='" + country + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", state=" + state +
                '}';
    }
}
