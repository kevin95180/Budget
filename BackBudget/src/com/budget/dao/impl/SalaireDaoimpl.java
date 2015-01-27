package com.budget.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.budget.dao.ISalaireDao;
import com.budget.entity.Salaire;

@Transactional
@Component
public class SalaireDaoimpl implements ISalaireDao {
	
	Logger log = Logger.getLogger(getClass());

	protected EntityManager em;

	@PersistenceContext(unitName = "entityManagerFactory")
	public void setEntityManager(EntityManager entityManager) {
		this.em = entityManager;
	}

	@Override
	public void createSalaire(Salaire entity) {
		entity.setEditable(false);
		em.persist(entity);
		em.flush();
		log.info("Enregistrement du salaire");
	}

	@Override
	public void updateSalaire(String nomSalaire, double sommeSalaire) {
		Salaire entity = findSalaire(nomSalaire);
		entity.setSommeSalaire(sommeSalaire);
		entity.setEditable(false);
		em.merge(entity);
		log.info("Mise à jour du salaire");
	}

	@Override
	public void deleteSalaire(String nomSalaire) {
		Salaire entity = findSalaire(nomSalaire);
		Salaire toRemoved = em.merge(entity);
		em.remove(toRemoved);
		log.info("Suppression du salaire");
	}

	@Override
	public Salaire findSalaire(String nomSalaire) {
		log.info("dao cherche le salaire dont le nom est en parametre");
		try{
			TypedQuery<Salaire> queryFindNomSalaire = em.createNamedQuery("Salaire.nomSalaireFindByNom", Salaire.class);
			queryFindNomSalaire.setParameter("nomSalaire", nomSalaire);
			return queryFindNomSalaire.getSingleResult();
		}catch(NoResultException e){
    		return null;
    	}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Salaire> findAll() {
		Query q = em.createQuery("FROM Salaire");
		return (List<Salaire>) q.getResultList();
	}

	@Override
	public double totalSalaire() {
		double total=0;
		for (int i=0; i < findAll().size(); i++){
			total += findAll().get(i).getSommeSalaire();
		}
		return total;
	}

	@Override
	public void editableSalaire(String nomSalaire) {
		Salaire entity = findSalaire(nomSalaire);
		entity.setEditable(true);
		em.merge(entity);
		log.info("Le salaire est maintenant editable");
	}

}
