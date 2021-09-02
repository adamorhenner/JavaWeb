package br.com.drogaria.dao;

import javax.persistence.EntityManager;

import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.util.JPAUtil;

public class FabricanteDAO {

	private EntityManager entityManage;
	
//	public FabricanteDAO(EntityManager em) {
//	this.entityManage = em;
//	}
	
	public void cadastrar(Fabricante fabricante) {
		try {
			
			entityManage = JPAUtil.getEntityManager();
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
	
	public Fabricante buscar(int id) {
		try {
			
			entityManage = JPAUtil.getEntityManager();
			entityManage.getTransaction().begin();
			
			return entityManage.find(Fabricante.class, id);
			
		} catch (Exception e) {
			entityManage.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			entityManage.close();
		}
		return null;
	}
	
	public void remover(int id) {
		try {
			
			entityManage = JPAUtil.getEntityManager();
			entityManage.getTransaction().begin();
			
			
			
			this.entityManage.remove(entityManage.find(Fabricante.class, id));
			
			
			
			entityManage.getTransaction().commit();
			
		} catch (Exception e) {
			entityManage.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			entityManage.close();
		}
	}
	
	public void atualizar(Fabricante fabricante) {
		try {
			
			entityManage = JPAUtil.getEntityManager();
			entityManage.getTransaction().begin();
			
			
			
			this.entityManage.merge(fabricante);
			

			
			entityManage.getTransaction().commit();
			
		} catch (Exception e) {
			entityManage.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			entityManage.close();
		}
	}
	
	
}
