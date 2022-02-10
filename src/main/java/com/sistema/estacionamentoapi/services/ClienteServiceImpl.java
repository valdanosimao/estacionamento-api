package com.sistema.estacionamentoapi.services;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.estacionamentoapi.entities.Cliente;
import com.sistema.estacionamentoapi.repository.ClienteRepositorio;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteRepositorio clienteRepositorio;

	@Override
	public List<Cliente> getAllClientes() {		
		return clienteRepositorio.findAll();
	}

	@Override
	public void salvarCliente(Cliente cliente) {
		this.clienteRepositorio.save(cliente);
		
	}

	@Override
	public Cliente getClienteById(Long id) {
		Optional<Cliente> optional = clienteRepositorio.findById(id);
		Cliente cliente = null;
		if(optional.isPresent()) {
			cliente = optional.get();
		}else {
			throw new RuntimeErrorException(null, "Cliente not found for id :: " + id);
		}
		return cliente;
	}

	@Override
	public void deletarClienteById(Long id) {
		this.clienteRepositorio.deleteById(id);
		
	}

}
