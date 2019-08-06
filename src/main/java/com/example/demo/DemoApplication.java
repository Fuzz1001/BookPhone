package com.example.demo;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.sql.SQLException;


@SpringBootApplication

public class DemoApplication {

    public static void main(String[] args) throws IOException, SQLException {

        SpringApplication.run(DemoApplication.class, args);

    }

}
