package br.com.drogaria.bean;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;

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
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

}