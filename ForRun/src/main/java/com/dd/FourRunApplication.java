package com.dd;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com"})
public class FourRunApplication {
    public static void main(String[] args) {
        SpringApplication.run(FourRunApplication.class, args);
    }
}
