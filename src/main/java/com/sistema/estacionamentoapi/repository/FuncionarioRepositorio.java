package com.sistema.estacionamentoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.estacionamentoapi.entities.Funcionario;

@Repository
public interface FuncionarioRepositorio  extends JpaRepository<Funcionario, Long>{

}
