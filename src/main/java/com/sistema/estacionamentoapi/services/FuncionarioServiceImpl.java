package com.sistema.estacionamentoapi.services;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.estacionamentoapi.entities.Funcionario;
import com.sistema.estacionamentoapi.repository.FuncionarioRepositorio;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {
	
	@Autowired
	private FuncionarioRepositorio funcionarioRepositorio;

	@Override
	public List<Funcionario> getAllFuncionario() {		
		return funcionarioRepositorio.findAll();
	}

	@Override
	public void salvarFuncionario(Funcionario funcionario) {
		this.funcionarioRepositorio.save(funcionario);
		
	}

	@Override
	public Funcionario getFuncionarioById(Long id) {
		
		Optional<Funcionario> optional = funcionarioRepositorio.findById(id);
		Funcionario funcionario = null;
		if(optional.isPresent()) {
			funcionario = optional.get();
		}else {
			throw new RuntimeErrorException(null, "Funcionario not found for id :: " + id);
		}
		return funcionario;
	}

	@Override
	public void deletarFuncionarioById(Long id) {
		this.funcionarioRepositorio.deleteById(id);
		
	}

}
