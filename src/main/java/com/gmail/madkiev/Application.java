package com.gmail.madkiev;

import com.gmail.madkiev.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.gmail.madkiev")
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    protected CommandLineRunner init() {

        return args -> {
            User user = new User();
            user.setUsername("publisher");
            user.setPassword("password");
            user.setName("publisher");
            user.setEmail("publisher@mail.com");

        };
    }
}



