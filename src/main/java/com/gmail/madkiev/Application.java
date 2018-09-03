package com.gmail.madkiev;

import ch.qos.logback.core.net.server.Client;
import com.gmail.madkiev.service.BlogPostService;
import com.gmail.madkiev.service.BlogPostServiceImpl;
import org.apache.catalina.WebResource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import sun.misc.BASE64Encoder;

@ComponentScan(basePackages = "com.gmail.madkiev")
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    protected BlogPostService blogPostService(){
        return new BlogPostServiceImpl();
    }
}



