package com.example.proyecto.Repository;

import com.example.proyecto.Model.Descuento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DescuentoRepository extends JpaRepository<Descuento, Long> {

    //Select * from descuento where nombreDescuento = ?
    @Query("SELECT d from Descuento d where d.nombreDescuento = ?1")
    Optional<Descuento> findByNombreDescuento(String nombreDescuento);
}
