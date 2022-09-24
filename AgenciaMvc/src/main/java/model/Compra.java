package model;

import java.util.ArrayList;
import java.util.List;

public class Compra {
	private int id_compra;
	private double valor_compra;
	private String data_compra;
	private Usuario usuario;

	// Listas produtos
	private List<ItemPassagem> itensPassagens = new ArrayList<ItemPassagem>();
	private List<ItemHospedagem> itensHospedagens = new ArrayList<ItemHospedagem>();

	// Gets e Sets ArrayList
	public List<ItemPassagem> getItensPassagens() {
		return itensPassagens;
	}

	public void setItensPassagens(List<ItemPassagem> itensPassagens) {
		this.itensPassagens = itensPassagens;
	}

	public List<ItemHospedagem> getItensHospedagens() {
		return itensHospedagens;
	}

	public void setItensHospedagens(List<ItemHospedagem> itensHospedagens) {
		this.itensHospedagens = itensHospedagens;
	}

	// Contrutor
	public Compra(int id_compra, String data_compra, Usuario usuario) {
		this.id_compra = id_compra;
		this.data_compra = data_compra;
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	// Gets e Sets
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Compra() {
	}

	// Gets e Sets
	public int getId_compra() {
		return id_compra;
	}

	public void setId_compra(int id_compra) {
		this.id_compra = id_compra;
	}

	public double getValor_compra() {
		return valor_compra;
	}

	public void setValor_compra(double valor_compra) {
		this.valor_compra = valor_compra;
	}

	public String getData_compra() {
		return data_compra;
	}

	public void setData_compra(String data_compra) {
		this.data_compra = data_compra;
	}

	// Metodos Finalizar compra e mostra valor final
	public double FinalizarCompraPassagens() {
		for (int i = 0; i < itensPassagens.size(); i++) {
			this.valor_compra += itensPassagens.get(i).getTotal_Valor_item();
		}
		return this.valor_compra;
	}

	public double FinalizarCompraHospedagens() {
		for (int i = 0; i < itensHospedagens.size(); i++) {
			this.valor_compra += itensHospedagens.get(i).getTotal_Valor_item();
		}
		return this.valor_compra;
	}

}
