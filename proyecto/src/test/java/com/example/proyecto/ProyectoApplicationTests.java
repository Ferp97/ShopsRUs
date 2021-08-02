package com.example.proyecto;

import com.example.proyecto.Model.Cliente;
import com.example.proyecto.Model.Descuento;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.Month;

class ProyectoApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl(){
		return "http://localhost:" + port;
	}

	@Test
	void contextLoads() {
	}

	@Test
	public void testGetAllClientes() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/api/clientes",
				HttpMethod.GET, entity, String.class);

		Assert.assertNotNull(response.getBody());
	}

	@Test
	public void testGetClienteById() {
		Cliente cliente = restTemplate.getForObject(getRootUrl() + "/api/clienteId/1", Cliente.class);
		System.out.println(cliente);
		Assert.assertNotNull(cliente);
	}

	@Test
	public void testGetClienteByNombre() {
		Cliente cliente = restTemplate.getForObject(getRootUrl() + "/api/clienteNombre/Fernanda Porras", Cliente.class);
		System.out.println(cliente);
		Assert.assertNotNull(cliente);
	}

	@Test
	public void testAgregarNuevoCliente() {
		Cliente cliente = restTemplate.getForObject(getRootUrl() + "api/clientes", Cliente.class);
		cliente.setIdentificacion(000001);
		cliente.setNombre("Test Testest");
		cliente.setFechaCreacion(LocalDate.of(2021, Month.AUGUST,8));
		cliente.setTipoCliente("Afiliado");
	}

	@Test
	public void testGetAllDescuentos() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/api/descuento",
				HttpMethod.GET, entity, String.class);

		Assert.assertNotNull(response.getBody());
	}

	@Test
	public void testAgregarNuevoDescuento() {
		Descuento descuento = restTemplate.getForObject(getRootUrl() + "/api/descuento", Descuento.class);
		descuento.setNombreDescuento("Nuevo descuento");
		descuento.setPorcentaje(0.7);
	}

	@Test
	public void testGetAllFacturas() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "api/factura",
				HttpMethod.GET, entity, String.class);

		Assert.assertNotNull(response.getBody());
	}

}
