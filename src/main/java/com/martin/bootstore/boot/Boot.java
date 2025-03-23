package com.martin.bootstore.boot;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Boot {

    public Boot(){}

    public Boot(String brandName, String name, String description, int size, double price) {
        this.brandName = brandName;
        this.name = name;
        this.description = description;
        this.size = size;
        this.price = price;
    }

    @Id
    @SequenceGenerator(
            name = "boot_sequence",
            sequenceName = "boot_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "boot_sequence"
    )
    private Long id;
    private String brandName;
    private String name;
    private String description;
    private int size;
    private double price;
}
