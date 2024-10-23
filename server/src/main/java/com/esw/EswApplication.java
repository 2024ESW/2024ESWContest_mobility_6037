package com.esw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EswApplication {

    public static void main(String[] args) {
        SpringApplication.run(EswApplication.class, args);
    }

}
