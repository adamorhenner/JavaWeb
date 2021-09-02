package br.com.drogaria.factory;

import javax.persistence.EntityManager;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Produto;
import br.com.drogaria.util.JPAUtil;



public class CadastroDeProduto {
	public static void main(String[] args) {
		
//		EntityManager em = JPAUtil.getEntityManager();
//		FabricanteDAO f1 = new FabricanteDAO(em);
//		ProdutoDAO celular2 = new ProdutoDAO(em);
//		
//		Produto celular = new Produto();
//		
//		
//		celular.setDescricao("bbbbbbbb");
//		celular.setFabricante(f1.buscar(2));
//		celular.setPreco(10000.00);
//		
//		celular2.cadastrar(celular);
		
//		- DELETAR PRODUTO
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO dao = new ProdutoDAO(em);
		
		dao.remover(6);
//		
		
//		EntityManager em = JPAUtil.getEntityManager();
//		ProdutoDAO dao = new ProdutoDAO(em);
//
//		Produto pd = new Produto();
//		pd.setDescricao("cccccc");
//		pd.setPreco(990.0);
//		
//		dao.editar(pd, 5);
		
//
//		dao.editar(pd);
		
		
		
		Produto f1 = dao.buscar(2);
		f1.setDescricao("Nokia");
		dao.atualizar(f1);

		
		
		
	   }
}
