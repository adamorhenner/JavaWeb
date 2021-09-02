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
	
	public Produto buscar(int id) {
		return entityManage.find(Produto.class, id);
	}
	
	
	public void remover(int id) {
		try {
			entityManage.getTransaction().begin();
			
			
			
			this.entityManage.remove(entityManage.find(Produto.class, id));
			
			
			
			entityManage.getTransaction().commit();
			
		} catch (Exception e) {
			entityManage.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			entityManage.close();
		}
	}
	
//	public void atualizar(Produto produto, int id) {
//		try {
//			entityManage.getTransaction().begin();
//			
//			
//			Produto produtoAchado = entityManage.find(Produto.class, id);
//			produtoAchado = produto;
//			
//			entityManage.merge(produtoAchado);
//			
//			
//			
//			entityManage.getTransaction().commit();
//			
//		} catch (Exception e) {
//			entityManage.getTransaction().rollback();
//			e.printStackTrace();
//		} finally {
//			entityManage.close();
//		}
//		
	}
}

