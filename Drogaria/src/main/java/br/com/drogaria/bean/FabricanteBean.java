package br.com.drogaria.bean;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.exception.DaoException;
import br.com.drogaria.util.JSFUtil;

@ManagedBean(name = "MBFabricante")
@ViewScoped
public class FabricanteBean {
	private Fabricante fabricante;
	private ArrayList<Fabricante> itens;
	private ArrayList<Fabricante> intensFiltrados;

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public ArrayList<Fabricante> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Fabricante> itens) {
		this.itens = itens;
	}

	public ArrayList<Fabricante> getIntensFiltrados() {
		return intensFiltrados;
	}

	public void setIntensFiltrados(ArrayList<Fabricante> intensFiltrados) {
		this.intensFiltrados = intensFiltrados;
	}

	@PostConstruct
	public void prepararPesquisa() {
		try {
			FabricanteDAO dao = new FabricanteDAO();
			itens = dao.listar();

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
			
			itens = dao.listar();
			
			JSFUtil.adicionarMensagemSucesso("Fabricante Salvo Com Sucesso!");
			
		} catch (DaoException e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());

		}
		
	}
	
	
	public void excluir() {
		try {
			FabricanteDAO dao = new FabricanteDAO();
			
			
			dao.remover(fabricante.getCodigo());
			
			itens = dao.listar();
			
			JSFUtil.adicionarMensagemSucesso("Fabricante Removido Com Sucesso!");
			
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());

		}
	}
	
	
	public void editar() {
		try {
			FabricanteDAO dao = new FabricanteDAO();
			
			
			dao.atualizar(fabricante);
			
			itens = dao.listar();
			
			JSFUtil.adicionarMensagemSucesso("Fabricante Editado Com Sucesso!");
			
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());

		}
	}	
	


}