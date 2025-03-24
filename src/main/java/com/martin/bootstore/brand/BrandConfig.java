package com.martin.bootstore.brand;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BrandConfig {

    @Bean
    CommandLineRunner brandCommandLineRunner(BrandRepository brandRepository) {
        if (brandRepository.findAll().isEmpty()) {
            return args -> {
                Brand brand1 = new Brand(
                        "Sorel",
                        "We stand for warmth.",
                        1968
                );

                Brand brand2 = new Brand(
                        "Eddie Bauer",
                        "You have the power to go anywhere.",
                        1999
                );

                Brand brand3 = new Brand(
                        "Muck",
                        "You should never have to deal with wet feet.",
                        1983
                );

                brandRepository.saveAll(List.of(brand1, brand2, brand3));
            };
        }

        return args -> {
        };
    }
}
