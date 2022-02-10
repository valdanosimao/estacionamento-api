package com.sistema.estacionamentoapi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistema.estacionamentoapi.entities.Veiculo;

@Service
public interface VeiculoService {
	
	List<Veiculo> getAllVeiculos();
	void salvarVeiculo(Veiculo veiculo);
	Veiculo gelVeiculoById(Long id);
	void deletarVeiculoById(Long id);

}
