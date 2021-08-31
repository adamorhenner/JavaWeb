package br.com.drogaria.factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.drogaria.domain.Fabricante;

public class Conection {
	public static void main(String[] args) {
		EntityManagerFactory entidyManagerFactory = Persistence.createEntityManagerFactory("JavaWeb");
		EntityManager entityManager = entidyManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		Fabricante fabricanteParaAdicionar = new Fabricante();
		
		fabricanteParaAdicionar.setDescricao("possui 3 lojas");
		
		entityManager.persist(fabricanteParaAdicionar);
		entityManager.getTransaction().commit();
		
		
	}
}
