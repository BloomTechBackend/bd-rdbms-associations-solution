package com.bloomtech.associations.restaurants.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "restaurants")
public class Restaurant
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long restaurantid;

    private String name;

    private String address;

    private String city;

    private String state;

    private String telephone;

    private int seatcapacity;

    @ManyToMany()
    @JoinTable(name = "restaurantpayments",
        joinColumns = @JoinColumn(name = "restaurantid"),
        inverseJoinColumns = @JoinColumn(name = "paymentid"))
    Set<Payment> payments = new HashSet<>();

    @OneToMany(mappedBy = "restaurant",
        cascade = CascadeType.ALL,
        orphanRemoval = true)
    private List<Menu> menus = new ArrayList<>();

    public Restaurant()
    {
    }

    public Restaurant(String name, String address, String city, String state, String telephone, int seatcapacity, Set<Payment> payments, List<Menu> menus) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.telephone = telephone;
        this.seatcapacity = seatcapacity;
        this.payments = payments;
        this.menus = menus;
    }

    public long getRestaurantid()
    {
        return restaurantid;
    }

    public void setRestaurantid(long restaurantid)
    {
        this.restaurantid = restaurantid;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getTelephone()
    {
        return telephone;
    }

    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }

    public int getSeatcapacity()
    {
        return seatcapacity;
    }

    public void setSeatcapacity(int seatcapacity)
    {
        this.seatcapacity = seatcapacity;
    }

    public Set<Payment> getPayments()
    {
        return payments;
    }

    public void setPayments(Set<Payment> payments)
    {
        this.payments = payments;
    }

    public List<Menu> getMenus()
    {
        return menus;
    }

    public void setMenus(List<Menu> menus)
    {
        this.menus = menus;
    }
}