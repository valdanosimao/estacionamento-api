package com.sistema.estacionamentoapi.services;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.estacionamentoapi.entities.Veiculo;
import com.sistema.estacionamentoapi.repository.VeiculoRepositorio;

@Service
public class VeiculoServiceImpl implements VeiculoService {
	
	@Autowired
	private VeiculoRepositorio veiculoRepositorio;

	@Override
	public List<Veiculo> getAllVeiculos() {		
		return veiculoRepositorio.findAll();
	}

	@Override
	public void salvarVeiculo(Veiculo veiculo) {
		this.veiculoRepositorio.save(veiculo);		
	}

	@Override
	public Veiculo gelVeiculoById(Long id) {
		Optional<Veiculo> optional = veiculoRepositorio.findById(id);
		Veiculo veiculo = null;
		if(optional.isPresent()) {
			veiculo = optional.get();
		}else {
			throw new RuntimeErrorException(null, "Veiculo not found for id :: " + id);
		}
		
		return veiculo;
	}

	@Override
	public void deletarVeiculoById(Long id) {
		this.deletarVeiculoById(id);
		
	}

}
