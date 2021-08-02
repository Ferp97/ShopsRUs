package com.example.proyecto.Repository;

import com.example.proyecto.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    //Select * from cliente where identificacion = ?
    @Query("SELECT c from Cliente c where c.identificacion = ?1")
    Optional<Cliente> findByIdentificacion(int identificacion);


}
