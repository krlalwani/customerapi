package com.krltest.customerapi.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor

public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    @Enumerated(value = EnumType.STRING)
    private AddressType type;
    private String city;
    private int pincode;


    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    public Address(Long addressId, AddressType type, String city, int pincode) {
        this.addressId = addressId;
        this.type = type;
        this.city = city;
        this.pincode = pincode;
    }

    public Address(Long addressId, AddressType type, String city, int pincode, Customer customer) {
        this.addressId = addressId;
        this.type = type;
        this.city = city;
        this.pincode = pincode;
        this.customer = customer;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public AddressType getType() {
        return type;
    }

    public void setType(AddressType type) {
        this.type = type;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
