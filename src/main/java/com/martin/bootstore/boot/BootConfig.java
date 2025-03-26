package com.martin.bootstore.boot;

import com.martin.bootstore.brand.Brand;
import com.martin.bootstore.brand.BrandRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BootConfig {

    // Because you need to have the brand repository initialized to create boots that are associated to a brand,
    // you must run the application twice the first time you start it to fully initialize the database and seed it
    // with data.
    @Bean
    CommandLineRunner bootCommandLineRunner(BootRepository bootRepository, BrandRepository brandRepository) {
        if (bootRepository.findAll().isEmpty() && !brandRepository.findAll().isEmpty()) {
            return args -> {
                Boot boot1 = new Boot(
                        "Trekker",
                        brandRepository.findById(1L).isPresent() ? brandRepository.findById(1L).get() : null,
                        "A boot for any weather.",
                        BootGender.Unisex,
                        BootType.Winter,
                        5,
                        15,
                        24.99
                );

                Boot boot2 = new Boot(
                        "Montana",
                        brandRepository.findById(2L).isPresent() ? brandRepository.findById(2L).get() : null,
                        "They'll always keep you warm.",
                        BootGender.Men,
                        BootType.Hiking,
                        6,
                        14,
                        54.99
                );

                Boot boot3 = new Boot(
                        "Rubbers",
                        brandRepository.findById(3L).isPresent() ? brandRepository.findById(3L).get() : null,
                        "Your feet will not get wet with these boots.",
                        BootGender.Unisex,
                        BootType.Rain,
                        4,
                        16,
                        49.99
                );

                bootRepository.saveAll(List.of(boot1, boot2, boot3));
            };
        }

        return args -> {
        };
    }
}
