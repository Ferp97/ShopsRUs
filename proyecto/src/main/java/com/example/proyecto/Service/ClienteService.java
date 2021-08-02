package com.example.proyecto.Service;

import com.example.proyecto.Model.Cliente;
import com.example.proyecto.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> getClientes(){
        return clienteRepository.findAll();
    }

    public Cliente findById(long id) {
        List<Cliente> clientes = getClientes();
        for (Cliente cliente: clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }
    public Cliente findByNombre(String nombre) {
        List<Cliente> clientes = getClientes();
        for (Cliente cliente: clientes) {
            if (cliente.getNombre().equals(nombre)) {
                return cliente;
            }
        }
        return null;
    }

    public void agregarNuevoCliente(Cliente cliente){
        Optional<Cliente> clienteByIdentificacion =  clienteRepository
                .findByIdentificacion(cliente.getIdentificacion());
        if (clienteByIdentificacion.isPresent()){
            throw new IllegalStateException("El cliente ya existe.");
        }
        clienteRepository.save(cliente);
    }



}
