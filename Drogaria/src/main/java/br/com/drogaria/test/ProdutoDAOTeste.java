package br.com.drogaria.test;

import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Produto;
import br.com.drogaria.exception.DaoException;

public class ProdutoDAOTeste {
	@Test
	@Ignore
	public void salvar() throws DaoException {
		Produto p = new Produto();
		p.setDescricao("Novalgina com 10 comprimidos");
		p.setPreco(2.50);
		p.setQuantidade(13);
		
		Fabricante f = new Fabricante();
		f.setCodigo(65);
		
		p.setFabricante(f);
		
		ProdutoDAO dao = new ProdutoDAO();
		dao.cadastrar(p);
	}
	
	@Test
	@Ignore
	public void listar() throws DaoException {
		ProdutoDAO dao = new ProdutoDAO();
		ArrayList<Produto> lista = dao.listar();
		
		for(Produto p: lista) {
			System.out.println("Código do Produto: " + p.getCodigo());
			System.out.println("Descrição do Produto: " + p.getDescricao());
			System.out.println("Preço: " + p.getPreco());
			System.out.println("Quantidade: " + p.getFabricante().getCodigo());
			System.out.println("Descrição do Fabricante: " + p.getFabricante().getDescricao());
			System.out.println();
		}
	}
	
	
	@Test
	@Ignore
	public void remover() throws DaoException {
		Produto p = new Produto();
		p.setCodigo(2);
		
		ProdutoDAO dao = new ProdutoDAO();
		dao.remover(p.getCodigo());
	}
	
	@Test
	public void editar() throws DaoException {
		Produto p = new Produto();
		
		p.setCodigo(3);
		p.setDescricao("cataflan pomada com 60 gramas");
		p.setPreco(15.50);
		p.setQuantidade(150);
		
		Fabricante f = new Fabricante();
		f.setCodigo(6);
		
		p.setFabricante(f);
		
		ProdutoDAO dao = new ProdutoDAO();
		dao.atualizar(p);
		
	}
}
