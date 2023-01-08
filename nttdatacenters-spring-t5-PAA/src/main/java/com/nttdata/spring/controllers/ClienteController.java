package com.nttdata.spring.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.nttdata.spring.models.Cliente;
import com.nttdata.spring.service.ClienteServicioI;

/**
 * Controlador cliente.
 */	
@RestController
@RequestMapping("/clientes")
public class ClienteController {
	@Autowired
	ClienteServicioI service;
	
	/**
	 * Exposicion de todos los clientes.
	 * @return
	 */
	@RequestMapping("mostrarClientes")
	public @ResponseBody List<Cliente> showAll(){
		return service.findAll();
	}
	
	/**
	 * Inscribe al cliente y nos muestra la página inicial.
	 * @param newClient
	 * @return
	 */
	@PostMapping("addCliente")
	public void addClient(@ModelAttribute("cliente") Cliente newClient) {
		service.addClient(newClient);
	}
	
	/**
	 * Exposicion clientes por nombre y apellidos.
	 * @param model
	 * @param nombre
	 * @param apellidos
	 * @return
	 */
	@RequestMapping("/consultarClientes")
	public @ResponseBody List<Cliente> filtraClientes(@RequestParam String nombre, @RequestParam String apellidos) {
		
		return service.buscaNombreApellidos(nombre, apellidos);
		
	}
	
}
