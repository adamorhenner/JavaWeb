package br.com.drogaria.dao;

import javax.persistence.EntityManager;

import br.com.drogaria.domain.Fabricante;

public class FabricanteDAO {

	private EntityManager entityManage;
	
	public FabricanteDAO(EntityManager em) {
	this.entityManage = em;
	}
	
	public void cadastrar(Fabricante fabricante) {
		try {
			entityManage.getTransaction().begin();
			this.entityManage.persist(fabricante);
			entityManage.getTransaction().commit();
			
		} catch (Exception e) {
			entityManage.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			entityManage.close();
		}
	}
}
