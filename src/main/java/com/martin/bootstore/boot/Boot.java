package com.martin.bootstore.boot;


import jakarta.persistence.*;

@Entity
@Table
public class Boot {
    @Id
    @SequenceGenerator(
            name = "boot_sequence",
            sequenceName = "boot_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String brandName;
    private String name;
    private String description;
    private int size;
    private double price;

    public Boot() {
    }

    public Boot(Long id, String brandName, String name, String description, int size, double price) {
        this.id = id;
        this.brandName = brandName;
        this.name = name;
        this.description = description;
        this.size = size;
        this.price = price;
    }

    public Boot(String brandName, String name, String description, int size, double price) {
        this.brandName = brandName;
        this.name = name;
        this.description = description;
        this.size = size;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Boot{" +
                "id=" + id +
                ", brandName='" + brandName + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", size=" + size +
                ", price=" + price +
                '}';
    }
}
