package br.com.drogaria.factory;

import javax.persistence.EntityManager;
import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.util.JPAUtil;

public class CadastroDeFabricante {
	public static void main(String[] args) {
	Fabricante Apple = new Fabricante();
	Apple.setDescricao("Muito caro");

	EntityManager em = JPAUtil.getEntityManager();
	FabricanteDAO dao = new FabricanteDAO(em);
	
	dao.cadastrar(Apple);
	
	

   }

}
