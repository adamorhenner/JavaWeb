package br.com.drogaria.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.drogaria.domain.Produto;
import br.com.drogaria.exception.DaoException;
import br.com.drogaria.util.JPAUtil;

public class ProdutoDAO {
	private EntityManager entityManage;
	
//	public ProdutoDAO(EntityManager em) {
//	this.entityManage = em;
//	}
	
	public void cadastrar(Produto produto) throws DaoException {
		try {
			entityManage = JPAUtil.getEntityManager();
			entityManage.getTransaction().begin();
			this.entityManage.persist(produto);
			entityManage.getTransaction().commit();
			
		} catch (Exception e) {
			entityManage.getTransaction().rollback();
			e.printStackTrace();
			throw new DaoException("Erro ao cadastrar!");
		} finally {
			entityManage.close();
		}
	}
	
	public Produto buscar(int id) {
        if (entityManage == null || !entityManage.isOpen()) {
            entityManage = JPAUtil.getEntityManager();
        }
        return entityManage.find(Produto.class, id);
    }
	
	
	public void remover(int id) throws DaoException{
		try {
			entityManage = JPAUtil.getEntityManager();
			entityManage.getTransaction().begin();
			
			
			
			Produto produtoBuscado = this.buscar(id);
			this.entityManage.remove(produtoBuscado);
			
			
			
			entityManage.getTransaction().commit();
			
		} catch (Exception e) {
			entityManage.getTransaction().rollback();
			e.printStackTrace();
			throw new DaoException("Erro ao Remover");
		} finally {
			entityManage.close();
		}
	}
	
	public void atualizar(Produto produto) throws DaoException {
		try {

			entityManage = JPAUtil.getEntityManager();
			entityManage.getTransaction().begin();

			this.entityManage.merge(produto);

			entityManage.getTransaction().commit();

		} catch (Exception e) {
			entityManage.getTransaction().rollback();
			e.printStackTrace();
			throw new DaoException("Erro ao Atualizar");
		} finally {
			entityManage.close();
		}
	}
	
	public ArrayList<Produto> listar() throws DaoException {
		List<Produto> produtos = new ArrayList<Produto>();

		try {
			entityManage = JPAUtil.getEntityManager();
			entityManage.getTransaction().begin();
			
			String queryList = "select p from Produto p inner join fetch p.fabricante f";
			List<Produto> produtoList = entityManage.createQuery(queryList, Produto.class).getResultList();
			
			
			produtos.addAll(produtoList);

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Erro ao listar");
			throw new DaoException("Erro 301");
		} finally {
			entityManage.close();
		}	
		
		return (ArrayList<Produto>) produtos;

	}
	

}
	
	
	
	
	
	
	
	
	
	
	


