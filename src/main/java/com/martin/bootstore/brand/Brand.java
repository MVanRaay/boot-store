package com.martin.bootstore.brand;

import com.martin.bootstore.boot.Boot;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
public class Brand {
    public Brand(){}

    public Brand(Long brandId, String name, String description, int yearFounded) {
        this.brandId = brandId;
        this.name = name;
        this.description = description;
        this.yearFounded = yearFounded;
    }

    public Brand(String name, String description, Integer yearFounded) {
        this.name = name;
        this.description = description;
        this.yearFounded = yearFounded;
    }

    @Id
    @SequenceGenerator(
            name = "brand_sequence",
            sequenceName = "brand_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "brand_sequence"
    )
    private Long brandId;

    @NotBlank(message = "Brand Name is required.")
    @Size(min = 2, max = 20, message = "Brand Name must be between 2 and 20 characters long.")
    private String name;

    @NotBlank(message = "Brand Description is required.")
    @Size(min = 2, max = 200, message = "Brand Description must be between 2 and 200 characters long.")
    private String description;

    @Min(value = 1900, message = "Brand must be newer than 1900, sorry")
    @Max(value = 2025)
    private int yearFounded;

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Boot> boots = new ArrayList<>();
}
