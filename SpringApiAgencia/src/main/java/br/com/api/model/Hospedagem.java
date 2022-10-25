package br.com.api.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Hospedagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	private String empresa;

	@Column(nullable = false)
	private String endereco;

	@Column(nullable = false)
	private double preco_diaria;

	@Column(nullable = false, name = "data_hospedagem")
	@DateTimeFormat()
	private LocalDate data_hospedagem;
	
	@Column(nullable = false)
	private String imagem;

	@Override
	public int hashCode() {
		return Objects.hash(data_hospedagem, empresa, endereco, id, imagem, preco_diaria);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hospedagem other = (Hospedagem) obj;
		return Objects.equals(data_hospedagem, other.data_hospedagem) && Objects.equals(empresa, other.empresa)
				&& Objects.equals(endereco, other.endereco) && id == other.id && Objects.equals(imagem, other.imagem)
				&& Double.doubleToLongBits(preco_diaria) == Double.doubleToLongBits(other.preco_diaria);
	}

	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public double getPreco_diaria() {
		return preco_diaria;
	}

	public void setPreco_diaria(double preco_diaria) {
		this.preco_diaria = preco_diaria;
	}

	public LocalDate getData_hospedagem() {
		return data_hospedagem;
	}

	public void setData_hospedagem(LocalDate data_hospedagem) {
		this.data_hospedagem = data_hospedagem;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

}
