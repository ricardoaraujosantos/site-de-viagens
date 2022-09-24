package model;

public class Hospedagem {
	// Atributos
	private int id_hospedagem;
	private String empresa;
	private String endereco;
	private String imagem;
	private String data_hospedagem;
	private double valor_diaria;

	// Contrutor
	

	public Hospedagem(int id_hospedagem, String empresa, String endereco, double valor_diaria, String imagem,
			String data_hospedagem) {
		this.id_hospedagem = id_hospedagem;
		this.empresa = empresa;
		this.endereco = endereco;
		this.valor_diaria = valor_diaria;
		this.imagem = imagem;
		this.data_hospedagem = data_hospedagem;
	}

	public Hospedagem() {
	}

	public int getId_hospedagem() {
		return id_hospedagem;
	}

	public void setId_hospedagem(int id_hospedagem) {
		this.id_hospedagem = id_hospedagem;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public double getValor_diaria() {
		return valor_diaria;
	}

	public void setValor_diaria(double valor_diaria) {
		this.valor_diaria = valor_diaria;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getData_hospedagem() {
		return data_hospedagem;
	}

	public void setData_hospedagem(String data_hospedagem) {
		this.data_hospedagem = data_hospedagem;
	}

}
