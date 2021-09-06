package br.com.drogaria.factory;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;

public class CadastroDeFabricante {
	public static void main(String[] args) {
		//- Cadastrar
//		Fabricante nokia = new Fabricante();
//		nokia.setDescricao("nokia");
//		FabricanteDAO dao = new FabricanteDAO();
//		dao.cadastrar(nokia);
		
		// - Atualizar itens
//		FabricanteDAO dao = new FabricanteDAO();	
//		Fabricante f2 = dao.buscar(1);
//		f2.setDescricao("Xiaomi");
//		dao.atualizar(f2);
		
		// - Remover Item:
		FabricanteDAO dao = new FabricanteDAO();	
		dao.listar();
		
		
		
		
		
		

   }
}
