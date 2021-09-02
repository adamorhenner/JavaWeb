package br.com.drogaria.factory;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;

public class CadastroDeFabricante {
	public static void main(String[] args) {
	
//	Fabricante nokia = new Fabricante();
//	nokia.setDescricao("nokia");
//
//	EntityManager em = JPAUtil.getEntityManager();
//	FabricanteDAO dao = new FabricanteDAO(em);
//	
//	dao.cadastrar(nokia);
//	
//	Fabricante motorola = new Fabricante();
//	motorola.setDescricao("motorola");
//
//	
//	em = JPAUtil.getEntityManager();
//	FabricanteDAO f2 = new FabricanteDAO(em);
//	
//	f2.cadastrar(motorola);

		FabricanteDAO dao = new FabricanteDAO();
		
		
		
		Fabricante f2 = dao.buscar(1);
		f2.setDescricao("Xiaomi");
		dao.atualizar(f2);
		

   }
}
