package com.esprit.examen.controllers;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.esprit.examen.entities.Operateur;
import com.esprit.examen.services.IOperateurService;

import io.swagger.annotations.Api;

@RestController
@Api(tags = "Gestion des opérateurs")
@RequestMapping("/operateur")
@RequiredArgsConstructor
public class OperateurController {


	private final IOperateurService operateurService;
	
	@GetMapping
	public List<Operateur> getOperateurs() {
		return operateurService.retrieveAllOperateurs();
	}

	@GetMapping("/{operateur-id}")


	@PostMapping
	public Operateur Operateur(@RequestBody Operateur op) {
		Operateur ope = operateurService.addOperateur(op);
		return ope;
	}

	@DeleteMapping("/{operateur-id}")
	public void removeOperateur(@PathVariable("operateur-id") Long operateurId) {
		operateurService.deleteOperateur(operateurId);
	}

	@PutMapping
	public Operateur modifierOperateur(@RequestBody Operateur operateur) {
		return operateurService.updateOperateur(operateur);
	}

	
}
