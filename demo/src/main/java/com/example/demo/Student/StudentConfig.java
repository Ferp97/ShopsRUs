package com.example.demo.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student kira = new Student(
                    "Kira",
                    "kira@perros.com",
                    LocalDate.of(2017, Month.DECEMBER, 23),
                    3
            );

            Student ellie = new Student(
                    "Ellie",
                    "ellie@perros.com",
                    LocalDate.of(2021, Month.APRIL, 29),
                    1
            );

            repository.saveAll(
                    List.of(kira,ellie)
            );
        };
    }

}
