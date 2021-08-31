package br.com.drogaria.dao;

import javax.persistence.EntityManager;

import br.com.drogaria.domain.Produto;

public class ProdutoDAO {
	private EntityManager entityManage;
	
	public ProdutoDAO(EntityManager em) {
	this.entityManage = em;
	}
	
	public void cadastrar(Produto produto) {
		try {
			entityManage.getTransaction().begin();
			this.entityManage.persist(produto);
			entityManage.getTransaction().commit();
			
		} catch (Exception e) {
			entityManage.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			entityManage.close();
		}
	}
}

