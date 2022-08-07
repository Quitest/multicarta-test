package ru.pel.tests.multicartatest.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String lastname;
    private int age;

    @ManyToOne
    @JsonManagedReference
    private Product purchaseItem;// - Содержимое покупки (ссылка на Покупку)
    private int count;// - Количество товара (например, 3)
    private double amount;// - Сумма покупки (например, 147.50) //FIXME для денег использовать BigDecimal
    private LocalDate purchaseDate;// - Дата покупки (например, 02.05.2019)

    public Payment() {
        //явное определение конструктора, чтобы его случайно не потерять при определении конструкторов с параметрами
    }

    //Далее идут геттеры и сеттеры
    public long getId() {
        return id;
    }

    public Payment setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Payment setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public Payment setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Payment setAge(int age) {
        this.age = age;
        return this;
    }


    public Product getPurchaseItem() {
        return purchaseItem;
    }

    public Payment setPurchaseItem(Product purchaseItem) {
        this.purchaseItem = purchaseItem;
        return this;
    }

    public int getCount() {
        return count;
    }

    public Payment setCount(int count) {
        this.count = count;
        return this;
    }

    public double getAmount() {
        return amount;
    }

    public Payment setAmount(double amount) {
        this.amount = amount;
        return this;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public Payment setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
        return this;
    }
}
