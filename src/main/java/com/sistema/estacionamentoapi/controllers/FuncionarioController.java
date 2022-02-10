package com.sistema.estacionamentoapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sistema.estacionamentoapi.entities.Funcionario;
import com.sistema.estacionamentoapi.services.FuncionarioService;

@Controller
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@GetMapping("/homeFuncionario")
	public String homeFuncionario(Model model) {
		model.addAttribute("objHomeFuncionario", funcionarioService.getAllFuncionario());
		return "funcionario/home_funcionario";		
	}
	
	@GetMapping("/novoFuncionario")
	public String novoFuncionario(Model model) {
		Funcionario funcionario = new Funcionario();
		model.addAttribute("objNovoFuncionario", funcionario);
		return "funcionario/novo_funcionario";
	}
	
	@PostMapping("/salvarFuncionario")
	public String salvarFuncionario(@ModelAttribute("salvarFuncionario") Funcionario funcionario) {
		funcionarioService.salvarFuncionario(funcionario);
		return "redirect:/";
	}
	
	@GetMapping("/atualizarFuncionario/{id}")
	public String atualizarFuncionario(@PathVariable("id") Long id, Model model) {
		Funcionario funcionario = funcionarioService.getFuncionarioById(id);
		model.addAttribute("objAtualizarFuncionario", funcionario);
		return "funcionario/atualizar_funcionario";
	}
	
	@GetMapping("/deletarFuncionario/{id}")
	public String deletarFuncionario(@PathVariable("id") Long id) {
		this.funcionarioService.deletarFuncionarioById(id);
		return "redirect:/";
	}	
	
	
}
