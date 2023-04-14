package com.esprit.examen.controllers;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.services.IFournisseurService;

import io.swagger.annotations.Api;


@RestController
@Api(tags = "Gestion des fournisseurss")
@RequestMapping("/fournisseur")
@RequiredArgsConstructor
public class FournisseurRestController {

	private final IFournisseurService fournisseurService;

	@GetMapping
	public List<Fournisseur> getFournisseurs() {
		return fournisseurService.retrieveAllFournisseurs();
	}

	@GetMapping("/{fournisseur-id}")
	public Fournisseur retrieveFournisseur(@PathVariable("fournisseur-id") Long fournisseurId) {
		return fournisseurService.retrieveFournisseur(fournisseurId);
	}

	@PostMapping
	public Fournisseur addFournisseur(@RequestBody Fournisseur f) {
		Fournisseur fournisseur = fournisseurService.addFournisseur(f);
		return fournisseur;
	}

	@DeleteMapping("/{fournisseur-id}")
	public void removeFournisseur(@PathVariable("fournisseur-id") Long fournisseurId) {
		fournisseurService.deleteFournisseur(fournisseurId);
	}

// Mettre à jour un fournisseur existant
	@PostMapping("/fournisseurs")
	public Fournisseur mettreAJourFournisseur(@RequestBody Fournisseur fournisseur) {
    	return fournisseurService.mettreAJourFournisseur(fournisseur);
	}

// Assigner un secteur d'activité à un fournisseur existant
	@PutMapping("/fournisseurs/{idFournisseur}/secteurs-activite/{idSecteurActivite}")
	public void assignerSecteurActiviteToFournisseur(@PathVariable Long idFournisseur, @PathVariable Long idSecteurActivite) {
    	fournisseurService.assignerSecteurActiviteToFournisseur(idFournisseur, idSecteurActivite);
	}


}
