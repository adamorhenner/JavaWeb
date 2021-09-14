package br.com.drogaria.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.exception.DaoException;
import br.com.drogaria.util.JPAUtil;

public class FabricanteDAO {

	private EntityManager entityManage;

//	public FabricanteDAO(EntityManager em) {
//	this.entityManage = em;
//	}

	public void cadastrar(Fabricante fabricante) throws DaoException {
		try {

			entityManage = JPAUtil.getEntityManager();
			entityManage.getTransaction().begin();

			this.entityManage.persist(fabricante);

			entityManage.getTransaction().commit();

		} catch (Exception e) {
			entityManage.getTransaction().rollback();
			e.printStackTrace();
			throw new DaoException("Erro ao cadastrar");
		} finally {
			entityManage.close();
		}
	}

	public Fabricante buscar(int id) {
        if (entityManage == null || !entityManage.isOpen()) {
            entityManage = JPAUtil.getEntityManager();
        }
        return entityManage.find(Fabricante.class, id);
    }

	public void remover(int id) throws DaoException {
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
			throw new DaoException("Erro ao remover");
		} finally {
			entityManage.close();
		}
	}

	public void atualizar(Fabricante fabricante) throws DaoException {
		try {

			entityManage = JPAUtil.getEntityManager();
			entityManage.getTransaction().begin();

			this.entityManage.merge(fabricante);

			entityManage.getTransaction().commit();

		} catch (Exception e) {
			entityManage.getTransaction().rollback();
			e.printStackTrace();
			throw new DaoException("Erro ao Atualizar");
		} finally {
			entityManage.close();
		}
	}

	public List<Fabricante> buscarPorDesc(String desc) throws DaoException {
		entityManage = JPAUtil.getEntityManager();
		entityManage.getTransaction().begin();

		try {
			String queryList = "SELECT f FROM Fabricante f WHERE f.descricao LIKE :descricao";
			List<Fabricante> fabricanteList = entityManage.createQuery(queryList, Fabricante.class)
					.setParameter("descricao", "%" + desc + "%").getResultList();

			return fabricanteList;

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Erro na pesquisa");
			throw new DaoException("Erro 300");
		} finally {
			entityManage.close();
		}
	}

	public ArrayList<Fabricante> listar() throws DaoException {

		try {
			entityManage = JPAUtil.getEntityManager();
			entityManage.getTransaction().begin();
			
			String queryList = "SELECT f FROM Fabricante f";
			List<Fabricante> fabricanteList = entityManage.createQuery(queryList, Fabricante.class).getResultList();
			
			return (ArrayList<Fabricante>) fabricanteList;
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Erro ao listar");
			throw new DaoException("Erro 301");
		} finally {
			entityManage.close();
		}	
	}
}
