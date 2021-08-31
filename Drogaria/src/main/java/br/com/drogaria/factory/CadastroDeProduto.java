package br.com.drogaria.factory;

import javax.persistence.EntityManager;

import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Produto;
import br.com.drogaria.util.JPAUtil;



public class CadastroDeProduto {
	public static void main(String[] args) {
		
		EntityManager em = JPAUtil.getEntityManager();
		Produto celular = new Produto();
		celular.setDescricao("aaaaaa");
		Fabricante fabricanteEntityManager = enti
		
		celular.setFabricante(em.find());

	   }
}
