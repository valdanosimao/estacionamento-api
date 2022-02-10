package com.sistema.estacionamentoapi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistema.estacionamentoapi.entities.Cliente;

@Service
public interface ClienteService {
	
	List<Cliente> getAllClientes();
	void salvarCliente(Cliente cliente);
	Cliente getClienteById(Long id);
	void deletarClienteById(Long id);

}
