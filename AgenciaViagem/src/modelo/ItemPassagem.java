package modelo;

public class ItemPassagem {
	// Atributos
	private int id_item_passagem;
	private int qtd_item;
	private double total_valor_item;
	private Compra compra;
	private Passagem passagem;

	// Contrutor
	public ItemPassagem(int id_item_passagem, int qtd_item, Compra compra, Passagem passagem) {
		this.id_item_passagem = id_item_passagem;
		this.qtd_item = qtd_item;
		this.total_valor_item = passagem.getValor_passagem() * qtd_item;
		this.compra = compra;
		this.passagem = passagem;
	}

	public ItemPassagem() {
	}

	// gets e Sets
	public int getId_item_passagem() {
		return id_item_passagem;
	}

	public void setId_item_passagem(int id_item_passagem) {
		this.id_item_passagem = id_item_passagem;
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

	public void setTotal_Valor_item(Passagem passagem) {
		this.total_valor_item = passagem.getValor_passagem() * qtd_item;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public Passagem getPassagem() {
		return passagem;
	}

	public void setPassagem(Passagem passagem) {
		this.passagem = passagem;
	}

}
