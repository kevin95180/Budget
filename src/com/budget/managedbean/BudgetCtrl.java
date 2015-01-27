package com.budget.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.budget.dto.DepenseDto;
import com.budget.dto.EntreeDto;
import com.budget.dto.SalaireDto;
import com.budget.entity.Depense;
import com.budget.entity.Entree;
import com.budget.entity.Salaire;
import com.budget.facade.Facade;

@Controller
@Scope("request")
public class BudgetCtrl {

	@Autowired
	Facade facade;

	private SalaireDto salaireDto = new SalaireDto();
	private EntreeDto entreeDto = new EntreeDto();
	private DepenseDto depenseDto = new DepenseDto();

	private Salaire salaire = new Salaire();
	private Depense depense = new Depense();
	private Entree entree = new Entree();

	@SuppressWarnings("unused")
	private List<Salaire> salaires = new ArrayList<Salaire>();
	@SuppressWarnings("unused")
	private List<Depense> depenses = new ArrayList<Depense>();
	@SuppressWarnings("unused")
	private List<Entree> entrees = new ArrayList<Entree>();

	@SuppressWarnings("unused")
	private double totalSalaire;
	@SuppressWarnings("unused")
	private double totalDepense;
	@SuppressWarnings("unused")
	private double totalEntree;
	@SuppressWarnings("unused")
	private double total;
	
	private boolean edit=false;
	
	// Méthode pour Salaire

	public String addSalaire() {
		if(facade.getSalaireService().findSalaire(salaireDto)){
			if(salaireDto.getSommeSalaire()>0){
				facade.getSalaireService().createSalaire(salaireDto);
				salaireDto = null;
				return "index";
			}
			FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage("Oppération Impossible",  "La somme doit être supérieure à 0") );
			return "index";
		}
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Impossible",  "Ce nom est déjà utilisé") );
		return "index";
	}

	public String updateSalaire(double somme) {
		BeanUtils.copyProperties(salaire, salaireDto);
		if(somme>0){
			salaireDto.setSommeSalaire(somme);
			facade.getSalaireService().updateSalaire(salaireDto);
			salaireDto = null;
			return "index";
		}
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Oppération Impossible",  "La somme doit être supérieure à 0") );
		return "index";
	}

	public String deleteSalaire() {
		BeanUtils.copyProperties(salaire, salaireDto);
		facade.getSalaireService().deleteSalaire(salaireDto);
		salaireDto = null;
		return "index";
	}

	public String editerSalaire() {
		BeanUtils.copyProperties(salaire, salaireDto);
		facade.getSalaireService().editableSalaire(salaireDto);
		edit=true;
		return "index";
	}

	// Méthode pour entree

	public String updateEntree(double somme) {
		if(somme>0){
			BeanUtils.copyProperties(entree, entreeDto);
			entreeDto.setSommeEntree(somme);
			facade.getEntreeService().updateEntree(entreeDto);
			entreeDto = null;
			return "index";
		}
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Oppération Impossible",  "La somme doit être supérieure à 0") );
		return "index";
	}

	public String addEntree() {
		if(facade.getEntreeService().findEntree(entreeDto)){
			if(entreeDto.getSommeEntree()>0){
				facade.getEntreeService().createEntree(entreeDto);
				entreeDto = null;
				return "index";
			}
			FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage("Oppération Impossible",  "La somme doit être supérieure à 0") );
			return "index";
		}
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Impossible",  "Ce nom est déjà utilisé") );
		return "index";
	}

	public String deleteEntree() {
		BeanUtils.copyProperties(entree, entreeDto);
		facade.getEntreeService().deleteEntree(entreeDto);
		entreeDto = null;
		return "index";
	}

	public String editerEntree() {
		BeanUtils.copyProperties(entree, entreeDto);
		facade.getEntreeService().editableEntree(entreeDto);
		edit=true;
		return "index";
	}

	// Méthode pour dépense

	public String addDepense() {
		if(facade.getDepenseService().findDepense(depenseDto)){
			if(depenseDto.getSommeDepense()>0){
				facade.getDepenseService().createDepense(depenseDto);
				depenseDto = null;
				return "index";
			}
			FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage("Oppération Impossible",  "La somme doit être supérieure à 0") );
			return "index";
		}
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Impossible",  "Ce nom est déjà utilisé") );
		return "index";
	}

	public String deleteDepense() {
		BeanUtils.copyProperties(depense, depenseDto);
		facade.getDepenseService().deleteDepense(depenseDto);
		depenseDto = null;
		return "index";
	}

	public String editerDepense() {
		BeanUtils.copyProperties(depense, depenseDto);
		facade.getDepenseService().editableDepense(depenseDto);
		edit=true;
		return "index";
	}

	public String updateDepense(double somme) {
		if(somme>0){
			BeanUtils.copyProperties(depense, depenseDto);
			depenseDto.setSommeDepense(somme);
			facade.getDepenseService().updateDepense(depenseDto);
			depenseDto = null;
			return "index";
		}
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Oppération Impossible",  "La somme doit être supérieure à 0") );
		return "index";
	}

	// Getters and Setters

	public SalaireDto getSalaireDto() {
		return salaireDto;
	}

	public void setSalaireDto(SalaireDto salaireDto) {
		this.salaireDto = salaireDto;
	}

	public EntreeDto getEntreeDto() {
		return entreeDto;
	}

	public void setEntreeDto(EntreeDto entreeDto) {
		this.entreeDto = entreeDto;
	}

	public DepenseDto getDepenseDto() {
		return depenseDto;
	}

	public void setDepenseDto(DepenseDto depenseDto) {
		this.depenseDto = depenseDto;
	}

	public List<Salaire> getSalaires() {
		return facade.getSalaireService().findAll();
	}

	public void setSalaires(List<Salaire> salaires) {
		this.salaires = salaires;
	}

	public List<Depense> getDepenses() {
		return facade.getDepenseService().findAll();
	}

	public void setDepenses(List<Depense> depenses) {
		this.depenses = depenses;
	}

	public List<Entree> getEntrees() {
		return facade.getEntreeService().findAll();
	}

	public void setEntrees(List<Entree> entrees) {
		this.entrees = entrees;
	}

	public double getTotalSalaire() {
		return (double)Math.round(facade.getSalaireService().totalSalaire()*100)/100;
	}

	public void setTotalSalaire(double totalSalaire) {
		this.totalSalaire = totalSalaire;
	}

	public double getTotalDepense() {
		return (double)Math.round(facade.getDepenseService().totalDepense()*100)/100;
	}

	public void setTotalDepense(double totalDepense) {
		this.totalDepense = totalDepense;
	}

	public double getTotalEntree() {
		return (double)Math.round(facade.getEntreeService().totalEntree() * 100)/100;
	}

	public void setTotalEntree(double totalEntree) {
		this.totalEntree = totalEntree;
	}

	public Salaire getSalaire() {
		return salaire;
	}

	public void setSalaire(Salaire salaire) {
		this.salaire = salaire;
	}

	public Depense getDepense() {
		return depense;
	}

	public void setDepense(Depense depense) {
		this.depense = depense;
	}

	public Entree getEntree() {
		return entree;
	}

	public void setEntree(Entree entree) {
		this.entree = entree;
	}

	public double getTotal() {
		return (double)Math.round((facade.getSalaireService().totalSalaire()
				+ facade.getEntreeService().totalEntree()
				- facade.getDepenseService().totalDepense())*100)/100;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}
	
}
