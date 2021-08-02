package com.example.proyecto.Repository;

import com.example.proyecto.Model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {

    //Select * from factura where idFactura = ?
    @Query("SELECT f from Factura f where f.idFactura = ?1")
    Optional<Factura> findById(Long idFactura);
}
