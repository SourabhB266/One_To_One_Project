package com.ty_one_to_one_uni.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty_one_to_one_uni1.dto.Pancard;
import com.ty_one_to_one_uni1.dto.Person;

public class PancardDao {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}
	
	public void savePancard(Pancard pancard ) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(pancard);
		entityTransaction.commit();
	}
	
	public void updatePancard(Pancard pancard) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(pancard);
		entityTransaction.commit();
	}
	public void deletePancard(Pancard pancard,int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Pancard pancard2  = entityManager.find(Pancard.class, id);
		entityTransaction.begin();
		entityManager.remove(pancard2);
		entityTransaction.commit();
	}
	public void getAllPancardById(Pancard pancard,int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Pancard pancard2  = entityManager.find(Pancard.class, id);
		System.out.println(pancard2);
	}
	public void getAllPancard() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select p from Person p");
		List<Person> list = query.getResultList();
		System.out.println(list);
	}
}
