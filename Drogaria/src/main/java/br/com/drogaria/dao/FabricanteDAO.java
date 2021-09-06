package br.com.drogaria.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.postgresql.core.ConnectionFactory;

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
			
//			Fabricante fabricanteBuscado = this.buscar(id);
//			this.entityManage.remove(entityManage.find(Fabricante.class, id));
			Fabricante fabricanteBuscado = this.buscar(id);
			this.entityManage.remove(fabricanteBuscado);

			
			
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
	
	public List<Fabricante> listar(){
		entityManage = JPAUtil.getEntityManager();

        try {
        String queryList = "SELECT f FROM Fabricante f ORDER BY descricao ASC";
        List<Fabricante> fabricanteList = entityManage
                .createQuery(queryList, Fabricante.class)
                .getResultList();

        return fabricanteList;
        } catch(Exception ex) {
            ex.printStackTrace();
            System.out.println("Erro ao listar");
        } finally {
            entityManage.close();
        }

        return null;
    }
	
	
}
