package br.com.drogaria.factory;


import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Produto;
import br.com.drogaria.exception.DaoException;



public class CadastroDeProduto {
	public static void main(String[] args) throws DaoException {
	
		int a = 0;
		int i = 1;

		//- Cadastrar
		while(a  <= 30) {
			Produto produto = new Produto();
			produto.setDescricao("PRODUTO " + i);
			ProdutoDAO dao = new ProdutoDAO();
			dao.cadastrar(produto);
			i++;
			a++;
		}
		
	   }
}
