package com.sistema.estacionamentoapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.sistema.estacionamentoapi.entities.Cliente;
import com.sistema.estacionamentoapi.services.ClienteService;

@Controller
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/homeCliente")
	public String homeCliente(Model model) {
		model.addAttribute("objHomeListaClientes", clienteService.getAllClientes());
		return "cliente/home_cliente";
	}
	
	@GetMapping("novoClienteForm")
	public String novoCliente(Model model) {
		Cliente cliente = new Cliente();
		
		model.addAttribute("objNovoCliente", cliente);
		return "cliente/novo_cliente";
	}
	
	@PostMapping("salvarCliente")
	public String salvarCliente(@ModelAttribute("salvarCliente")Cliente cliente ) {
			clienteService.salvarCliente(cliente);
			return "redirect:/homeCliente";
	}
	
	@GetMapping("atualizarCliente/{id}")
	public String atualizarCliente(@PathVariable("id") Long id, Model model) {
		Cliente cliente = clienteService.getClienteById(id);
		model.addAttribute("objAtualizarCliente", cliente);
		return "cliente/atualizar_cliente";
	}
	
	@GetMapping("deletarCliente/{id}")
	public String deletarCliente(@PathVariable("id") Long id) {
		this.clienteService.deletarClienteById(id);
		return"redirect:/homeCliente";
	}		
	
}
