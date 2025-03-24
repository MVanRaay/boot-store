package com.martin.bootstore.boot;

import com.martin.bootstore.brand.Brand;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Table
@Data
public class Boot {

    public Boot(){}

    public Boot(String name, Brand brand, String description, int size, double price) {
        this.name = name;
        this.brand = brand;
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
    private Long bootId;

    @NotBlank(message = "Boot Name is required.")
    @Size(min = 2, max = 20, message = "Boot Name must be between 2 and 20 characters long.")
    private String name;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private Brand brand;

    @NotBlank(message = "Description is required.")
    @Size(min = 2, max = 2000, message = "Description must be between 2 and 2000 characters long.")
    private String description;

    @NotNull(message = "Boot size is required.")
    @Min(value = 1, message = "Boot size must be greater than 1.")
    @Max(value = 20, message = "Boot size must be less than 20.")
    private int size;

    @NotNull(message = "Boot price is required.")
    @Min(value = 0, message = "Boot price must be greater than $0.")
    @Max(value = 100000, message = "Boot price must be less than $100, 000.")
    private double price;
}
