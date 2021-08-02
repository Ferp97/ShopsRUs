package com.example.proyecto.Configuration;

import com.example.proyecto.Model.Cliente;
import com.example.proyecto.Repository.ClienteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class ClienteConfig {

    @Bean
    CommandLineRunner commandLineRunner(ClienteRepository repository) {
        return args -> {
            Cliente cliente1 = new Cliente(
                    116940902,
                    "Fernanda Porras",
                    LocalDate.of(2021, Month.AUGUST, 8),
                    "Afiliado"
            );
            Cliente cliente2 = new Cliente(
                    11111111,
                    "Nombre1 Apellido1",
                    LocalDate.of(2020, Month.AUGUST, 8),
                    "Empleado"
            );
            Cliente cliente3 = new Cliente(
                    22222,
                    "Nombre2 Apellido2",
                    LocalDate.of(2018, Month.AUGUST, 8),
                    "Antiguo"
            );
            Cliente cliente4 = new Cliente(
                    33333,
                    "Nombre3 Apellido3",
                    LocalDate.of(2021, Month.JANUARY, 9),
                    "Afiliado"
            );
            repository.saveAll(List.of(cliente1, cliente2, cliente3, cliente4));
        };
    }
}
