package com.sistema.estacionamentoapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sistema.estacionamentoapi.entities.Veiculo;
import com.sistema.estacionamentoapi.services.VeiculoService;

@Controller
public class VeiculoController {
	
	@Autowired
	private VeiculoService veiculoService;
	
	@GetMapping("/homeVeiculo")
	public String homeVeiculo(Model model) {
		model.addAttribute("objHomeVeiculo", veiculoService.getAllVeiculos());
		return "veiculo/home_veiculo";
	}
	
	
	@GetMapping("/novoVeiculo")
	public String novoVeiculo(Model model) {
		Veiculo veiculo = new Veiculo();
		model.addAttribute("objNovoVeiculo", veiculo);
		return "veiculo/novo_veiculo";
	}
	
	@PostMapping("/salvarVeiculo")
	public String salvarVeiculo(@ModelAttribute("salvarVeiculo") Veiculo veiculo){
		veiculoService.salvarVeiculo(veiculo);
		return "redirect:/";
	}
	
	@GetMapping("/atualizarVeiculo/{id}")
	public String atualizarVeiculo(@PathVariable("id") Long id, Model model) {
		Veiculo veiculo = veiculoService.gelVeiculoById(id);
		model.addAttribute("objAtualizarveiculo", veiculo);
		return "veiculo/atualizar_veiculo";
	}
	
	@GetMapping("/deletarVeiculo/{id}")
	public String deletarVeiculo(@PathVariable("id") Long id) {
		this.veiculoService.deletarVeiculoById(id);
		return "redicect:/";
	}	
	
	
}
