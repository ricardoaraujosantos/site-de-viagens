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
public class Passagem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_passagem;

	@Column(nullable = false)
	private String empresa;
	
	@Column(nullable = false)
	private String embarque;
	
	@Column(nullable = false)
	private String desembarque;

	@Column(nullable = false)
	private double valor_passagem;

	@Column(nullable = false, name = "data_passagem")
	@DateTimeFormat()
	private LocalDate data_passagem;

	public long getId_passagem() {
		return id_passagem;
	}

	public void setId_passagem(long id_passagem) {
		this.id_passagem = id_passagem;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getEmbarque() {
		return embarque;
	}

	public void setEmbarque(String embarque) {
		this.embarque = embarque;
	}

	public String getDesembarque() {
		return desembarque;
	}

	public void setDesembarque(String desembarque) {
		this.desembarque = desembarque;
	}

	public double getValor_passagem() {
		return valor_passagem;
	}

	public void setValor_passagem(double valor_passagem) {
		this.valor_passagem = valor_passagem;
	}

	public LocalDate getData_passagem() {
		return data_passagem;
	}

	public void setData_passagem(LocalDate data_passagem) {
		this.data_passagem = data_passagem;
	}

	@Override
	public int hashCode() {
		return Objects.hash(data_passagem, desembarque, embarque, empresa, id_passagem, valor_passagem);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Passagem other = (Passagem) obj;
		return Objects.equals(data_passagem, other.data_passagem) && Objects.equals(desembarque, other.desembarque)
				&& Objects.equals(embarque, other.embarque) && Objects.equals(empresa, other.empresa)
				&& id_passagem == other.id_passagem
				&& Double.doubleToLongBits(valor_passagem) == Double.doubleToLongBits(other.valor_passagem);
	}


}
