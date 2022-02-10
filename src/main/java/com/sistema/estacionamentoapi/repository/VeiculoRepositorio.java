package com.sistema.estacionamentoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.estacionamentoapi.entities.Veiculo;

@Repository
public interface VeiculoRepositorio  extends JpaRepository<Veiculo, Long>{

}
