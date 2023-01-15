package com.ty_one_to_one_uni.dao;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty_one_to_one_uni1.dto.Person;

public class PersonDao {
	
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}
	
	public void savePerson(Person person) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(person);
		entityTransaction.commit();
	}
	
	public void updatePerson(Person person) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(person);
		entityTransaction.commit();
	}
	
	public void deletePerson(Person person,int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Person person2  = entityManager.find(Person.class, id);
		entityTransaction.begin();
		entityManager.remove(person2);
		entityTransaction.commit();
	}
	
	public void getAllPersonById(Person person,int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Person person2  = entityManager.find(Person.class, id);
		System.out.println(person2);
	}
	
	public void getAllPerson() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select p from Person p");
		List<Person> list = query.getResultList();
		System.out.println(list);
	}
}
