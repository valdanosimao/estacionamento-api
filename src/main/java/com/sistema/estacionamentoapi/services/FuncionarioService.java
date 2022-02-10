package com.sistema.estacionamentoapi.services;

import java.util.List;

import com.sistema.estacionamentoapi.entities.Funcionario;

public interface FuncionarioService {
	
	List<Funcionario> getAllFuncionario();
	void salvarFuncionario(Funcionario funcionario);
	Funcionario getFuncionarioById(Long id);
	void deletarFuncionarioById(Long id);
	

}
