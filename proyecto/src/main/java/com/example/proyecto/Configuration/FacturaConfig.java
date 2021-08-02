package com.example.proyecto.Configuration;

import com.example.proyecto.Model.Factura;
import com.example.proyecto.Repository.FacturaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class FacturaConfig {

    @Bean
    CommandLineRunner commandLineRunnerFactura(FacturaRepository repository) {
        return args -> {
            Factura factura1 = new Factura(
                    1L,
                    LocalDate.of(2021, Month.AUGUST, 8),
                    90000
            );

            repository.saveAll(List.of(factura1));
        };
    }
}
