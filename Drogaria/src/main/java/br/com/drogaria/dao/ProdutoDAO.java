package br.com.drogaria.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.drogaria.domain.Fabricante;
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
		return entityManage.find(Produto.class, id);
	}
	
	
	public void remover(int id) {
		try {
			entityManage = JPAUtil.getEntityManager();
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
	
	public void atualizar(Produto produto, int id) {
		try {
			entityManage = JPAUtil.getEntityManager();
			entityManage.getTransaction().begin();
			
			
			Produto produtoAchado = entityManage.find(Produto.class, id);
			produtoAchado = produto;
			
			entityManage.merge(produtoAchado);
			
			
			
			entityManage.getTransaction().commit();
			
		} catch (Exception e) {
			entityManage.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			entityManage.close();
		}
		
	}
	
	public ArrayList<Produto> listar() throws DaoException {

		try {
			entityManage = JPAUtil.getEntityManager();
			entityManage.getTransaction().begin();
			
			String queryList = "select p.codigo, p.descricao, p.preco, p.quantidade, f.codigo, f.descricao from produto p inner join fabricante f on f.codigo = p.codigo_fabricante";
			List<Produto> produtoList = entityManage.createQuery(queryList, Produto.class).getResultList();
			
			return (ArrayList<Produto>) produtoList;
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Erro ao listar");
			throw new DaoException("Erro 301");
		} finally {
			entityManage.close();
		}	
	}
}
	
	
	
	
	
	
	
	
	
	
	


