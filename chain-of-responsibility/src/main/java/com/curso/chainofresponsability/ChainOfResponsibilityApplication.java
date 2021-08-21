package com.curso.chainofresponsability;

import com.curso.chainofresponsability.repository.SearchZipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChainOfResponsibilityApplication implements CommandLineRunner {

    @Autowired
    private SearchZipRepository service;

    public static void main(String[] args) {
        SpringApplication.run(ChainOfResponsibilityApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(service.searchZipViaCep("14940000").getResponse());
    }
}
