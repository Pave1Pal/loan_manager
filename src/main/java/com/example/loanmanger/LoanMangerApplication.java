package com.example.loanmanger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableJpaAuditing
@EnableWebMvc
@SpringBootApplication
public class LoanMangerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoanMangerApplication.class, args);
    }

}
