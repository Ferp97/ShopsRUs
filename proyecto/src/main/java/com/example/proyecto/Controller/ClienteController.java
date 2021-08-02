package com.example.proyecto.Controller;

import com.example.proyecto.Model.Cliente;
import com.example.proyecto.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> getClientes(){
        return clienteService.getClientes();
    }

    @GetMapping(path = "/clienteId/{id}")
    public Cliente getClienteById(@PathVariable("id") Long id) {
        return clienteService.findById(id);
    }

    @GetMapping(path = "/clienteNombre/{nombre}")
    public Cliente getClienteByNombre(@PathVariable("nombre") String nombre) {
        return clienteService.findByNombre(nombre);
    }

    @PostMapping
    public void agregarNuevoCliente(@RequestBody Cliente cliente){
        clienteService.agregarNuevoCliente(cliente);
    }
}
