package dev.lordbrad.september;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"dev.lordbrad.september"})
public class SeptemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeptemberApplication.class, args);
    }

}
