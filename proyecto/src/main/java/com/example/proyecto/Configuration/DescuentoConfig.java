package com.example.proyecto.Configuration;

import com.example.proyecto.Model.Descuento;
import com.example.proyecto.Repository.DescuentoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class DescuentoConfig {

    @Bean
    CommandLineRunner commandLineRun(DescuentoRepository repository) {
        return args -> {
            Descuento descuentoAfiliado = new Descuento(
                    0.1,
                    "Afiliado"

            );
            Descuento descuentoEmpleado = new Descuento(
                    0.3,
                    "Empleado"

            );
            Descuento descuentoTiempo = new Descuento(
                    0.05,
                    "Cliente por mas de 2 años"

            );
            repository.saveAll(List.of(descuentoAfiliado, descuentoEmpleado, descuentoTiempo));
        };
    }
}
