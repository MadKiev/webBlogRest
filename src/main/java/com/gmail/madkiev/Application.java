package com.gmail.madkiev;

import com.gmail.madkiev.model.User;
import com.gmail.madkiev.security.BasicSecurityConfiguration;
import com.gmail.madkiev.service.BlogPostService;
import com.gmail.madkiev.service.BlogPostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;

@ComponentScan(basePackages = "com.gmail.madkiev")
@SpringBootApplication
//@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    protected BlogPostService blogPostService(){
        return new BlogPostServiceImpl();
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



