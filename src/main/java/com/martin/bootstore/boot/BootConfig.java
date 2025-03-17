package com.martin.bootstore.boot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BootConfig {

    @Bean
    CommandLineRunner commandLineRunner(BootRepository bootRepository) {
        return args -> {
            Boot boot1 = new Boot(
                    "Sorel",
                    "Trekker",
                    "A boot for any weather",
                    10,
                    24.99
            );

            Boot boot2 = new Boot(
                    "Eddie Bauer",
                    "Montana",
                    "They'll always keep you warm",
                    12,
                    54.99
            );

            bootRepository.saveAll(List.of(boot1, boot2));
        };
    }
}
