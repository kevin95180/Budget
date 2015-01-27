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

import com.budget.dao.IDepenseDao;
import com.budget.entity.Depense;

@Transactional
@Component
public class DepenseDaoImpl implements IDepenseDao {
	
	Logger log = Logger.getLogger(getClass());
	
	protected EntityManager em;
	
	@PersistenceContext(unitName="entityManagerFactory")
	public void setEntityManager(EntityManager entityManager) {
		this.em = entityManager;
	}
	
	@Override
	public void createDepense(Depense entity) {
		em.persist(entity);
		em.flush();
		log.info("Enregistrement de la depense");
	}

	@Override
	public void updateDepense(String nomDepense, double somme) {
		Depense entity = findDepense(nomDepense);
		entity.setSommeDepense(somme);
		entity.setEditable(false);
		em.merge(entity);
		log.info("Mise à jour de la depense");
	}

	@Override
	public void deleteDepense(String nomDepense) {
		Depense entity = findDepense(nomDepense);
		Depense toRemoved = em.merge(entity);
		em.remove(toRemoved);
		log.info("Suppression de la depense");
	}

	@Override
	public Depense findDepense(String nomDepense) {
		log.info("dao cherche la dépense dont le nom est en parametre");
		try{
			TypedQuery<Depense> queryFindNomDepense = em.createNamedQuery("Depense.nomDepenseFindByNom", Depense.class);
			queryFindNomDepense.setParameter("nomDepense", nomDepense);
			return queryFindNomDepense.getSingleResult();
		}catch(NoResultException e){
    		return null;
    	}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Depense> findAll() {
		Query q = em.createQuery("FROM Depense");
		return (List<Depense>) q.getResultList();
	}

	@Override
	public double totalDepense() {
		double total=0;
		for (int i=0; i < findAll().size(); i++){
			total += findAll().get(i).getSommeDepense();
		}
		return total;
	}

	@Override
	public void editableDepense(String nomDepense) {
		Depense entity = findDepense(nomDepense);
		entity.setEditable(true);
		em.merge(entity);
		log.info("La dépense est maintenant editable");
	}

}
