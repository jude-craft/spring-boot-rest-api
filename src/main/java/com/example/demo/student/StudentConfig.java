package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student hailey = new Student(
                    "Hailey",
                    "haileybarks@gmail.com",
                    LocalDate.of(2025, Month.NOVEMBER, 15),
                    2
            );
            Student jacob =  new Student(
                    "Jacob",
                    "jacobgates@gmail.com",
                    LocalDate.of(2005, Month.JANUARY, 15),
                    20
            );

            repository.saveAll(
                    List.of(hailey, jacob  )
            );
        };
    }
}
