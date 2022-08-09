package ru.pel.tests.multicartatest.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

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

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE}/*,fetch = FetchType.EAGER*/)
//    @JoinColumn(name = "purchase_item_id")
//    @JsonManagedReference
    @JsonProperty("item")
    private Product purchaseItem;// - Содержимое покупки (ссылка на Покупку)
    private int count;// - Количество товара (например, 3)
    private double amount;// - Сумма покупки (например, 147.50) //FIXME для денег использовать BigDecimal
    @JsonFormat(pattern = "yyyy-MM-dd")
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

    //    @JsonGetter("item")
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
