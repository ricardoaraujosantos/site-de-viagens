package model;

public class ItemHospedagem {
	private int id_item_Hospedagem;
	private int qtd_item;
	private double total_valor_item;
	private Compra compra;
	private Hospedagem hospedagem;

	// Construtor
	public ItemHospedagem(int id_item_Hospedagem, int qtd_item, Compra compra, Hospedagem hospedagem) {
		this.id_item_Hospedagem = id_item_Hospedagem;
		this.qtd_item = qtd_item;
		this.total_valor_item = hospedagem.getValor_diaria() * qtd_item;
		this.compra = compra;
		this.hospedagem = hospedagem;
	}

	public ItemHospedagem() {
	}

	// Gets e Sets
	public int getId_item_Hospedagem() {
		return id_item_Hospedagem;
	}

	public void setId_item_Hospedagem(int id_item_Hospedagem) {
		this.id_item_Hospedagem = id_item_Hospedagem;
	}

	public int getQtd_item() {
		return qtd_item;
	}

	public void setQtd_item(int qtd_item) {
		this.qtd_item = qtd_item;
	}

	public double getTotal_Valor_item() {
		return total_valor_item;
	}

	public void setTotal_Valor_item(Hospedagem hospedagem) {
		this.total_valor_item = hospedagem.getValor_diaria() * qtd_item;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public Hospedagem getHospedagem() {
		return hospedagem;
	}

	public void setHospedagem(Hospedagem hospedagem) {
		this.hospedagem = hospedagem;
	}

}
