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

import com.budget.dao.IEntreeDao;
import com.budget.entity.Entree;

@Transactional
@Component
public class EntreeDaoImpl implements IEntreeDao {

	Logger log = Logger.getLogger(getClass());

	protected EntityManager em;

	@PersistenceContext(unitName = "entityManagerFactory")
	public void setEntityManager(EntityManager entityManager) {
		this.em = entityManager;
	}

	@Override
	public void createEntree(Entree entity) {
		em.persist(entity);
		em.flush();
		log.info("Enregistrement de l'entree");
	}

	@Override
	public void updateEntree(String nomEntree, double sommeEntree) {
		Entree entity = findEntree(nomEntree);
		entity.setSommeEntree(sommeEntree);
		entity.setEditable(false);
		em.merge(entity);
		log.info("Mise à jour de l'entree");
	}

	@Override
	public void deleteEntree(String nomEntree) {
		Entree entity = findEntree(nomEntree);
		Entree toRemoved = em.merge(entity);
		em.remove(toRemoved);
		log.info("Suppression de l'entree");
	}

	@Override
	public Entree findEntree(String nomEntree) {
		log.info("dao cherche le salaire dont le nom est en parametre");
		try{
			TypedQuery<Entree> queryFindNomEntree = em.createNamedQuery("Entree.nomEntreeFindByNom", Entree.class);
			queryFindNomEntree.setParameter("nomEntree", nomEntree);
			return queryFindNomEntree.getSingleResult();
		}catch(NoResultException e){
    		return null;
    	}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Entree> findAll() {
		Query q = em.createQuery("FROM Entree");
		return (List<Entree>) q.getResultList();
	}

	@Override
	public double totalEntree() {
		double total=0;
		for (int i=0; i < findAll().size(); i++){
			total += findAll().get(i).getSommeEntree();
		}
		return total;
	}

	@Override
	public void editableEntree(String nomEntree) {
		Entree entity = findEntree(nomEntree);
		entity.setEditable(true);
		em.merge(entity);
		log.info("L'entrée est maintenant editable");
	}

}
