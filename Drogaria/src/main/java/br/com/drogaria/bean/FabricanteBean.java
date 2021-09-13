package br.com.drogaria.bean;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;


import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.exception.DaoException;
import br.com.drogaria.util.JSFUtil;

@ManagedBean(name = "MBFabricante")
@ViewScoped
public class FabricanteBean {
	private Fabricante fabricante;
	
	private ListDataModel<Fabricante> itens;

	public ListDataModel<Fabricante> getItens() {
		return itens;
	}

	public void setItens(ListDataModel<Fabricante> itens) {
		this.itens = itens;
	}

	@PostConstruct
	public void prepararPesquisa() {
		try {
			FabricanteDAO dao = new FabricanteDAO();
			ArrayList<Fabricante> lista = (ArrayList<Fabricante>) dao.listar();
			itens = new ListDataModel<Fabricante>(lista);
		} catch (Exception ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}
	
	public void prepararNovo() {
		fabricante = new Fabricante();
		
	}
	
	public void novo() {
		try {
			FabricanteDAO dao = new FabricanteDAO();
			dao.cadastrar(fabricante);
			
			ArrayList<Fabricante> lista = (ArrayList<Fabricante>) dao.listar();
			itens = new ListDataModel<Fabricante>(lista);
			
			JSFUtil.adicionarMensagemSucesso("Fabricante Salvo Com Sucesso!");
			
		} catch (DaoException e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());

		}
		
	}
	
	public void prepararExcluir() {
		fabricante = itens.getRowData(); 
	}
	
	public void excluir() {
		try {
			FabricanteDAO dao = new FabricanteDAO();
			
			
			dao.remover(fabricante.getCodigo());
			
			ArrayList<Fabricante> lista = (ArrayList<Fabricante>) dao.listar();
			itens = new ListDataModel<Fabricante>(lista);
			
			JSFUtil.adicionarMensagemSucesso("Fabricante Removido Com Sucesso!");
			
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());

		}
	}
	
	public void prepararEditar() {
		fabricante = itens.getRowData();
	}
	
	public void editar() {
		try {
			FabricanteDAO dao = new FabricanteDAO();
			
			
			dao.atualizar(fabricante);
			
			ArrayList<Fabricante> lista = (ArrayList<Fabricante>) dao.listar();
			itens = new ListDataModel<Fabricante>(lista);
			
			JSFUtil.adicionarMensagemSucesso("Fabricante Editado Com Sucesso!");
			
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());

		}
	}	
	

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

}