package br.com.drogaria.factory;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.exception.DaoException;

public class CadastroDeFabricante {
	public static void main(String[] args) throws DaoException {
		int a = 0;
		int i = 1;

		//- Cadastrar
		while(a  <= 30) {
			Fabricante fabricante = new Fabricante();
			fabricante.setDescricao("FABRICANTE " + i);
			FabricanteDAO dao = new FabricanteDAO();
			dao.cadastrar(fabricante);
			i++;
			a++;
		}
		// - Atualizar itens
//		FabricanteDAO dao = new FabricanteDAO();	
//		Fabricante f2 = dao.buscar(1);
//		f2.setDescricao("Xiaomi");
//		dao.atualizar(f2);
		
		// - Remover Item:
//		FabricanteDAO dao = new FabricanteDAO();	
//		dao.remover(6);

	}
}
