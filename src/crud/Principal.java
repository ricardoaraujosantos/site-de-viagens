package crud;

import java.util.Arrays;

import modelo.Compra;
import modelo.Hospedagem;
import modelo.ItemHospedagem;
import modelo.ItemPassagem;
import modelo.Passagem;
import modelo.Permissao;
import modelo.Usuario;

public class Principal {

	public static void main(String[] args) {
		Passagem passagem = new Passagem("Gol", "Guarulhos", "Galião", 850, "05/09/2022");
		Hospedagem  hospedagem = new Hospedagem("Hotel", "CopaCabana", 2000, "05/09/2022");
		
		Permissao admUser = new Permissao(1, "Administrador");
		Permissao commUser = new Permissao(2, "usuarioComum");
		
		Usuario usuario1 = new Usuario("Marcos", "marcos@", "4444","Av,,,", commUser);
		
		Compra compraP = new Compra(001, "01/09/2022", usuario1 );
		Compra compraH = new Compra(001, "01/09/2022", usuario1 );
		
		ItemPassagem itemPassagem = new ItemPassagem(0001, 2, compraP, passagem);
		ItemHospedagem itemHospedagem = new ItemHospedagem(1000, 2, compraH, hospedagem);
		
		compraP.getItensPassagens().addAll(Arrays.asList(itemPassagem));
		compraH.getItensHospedagens().addAll(Arrays.asList(itemHospedagem));
		
		for (ItemPassagem p : compraP.getItensPassagens()) {
			System.out.println("Quantidade: " + p.getQtd_item()
					+"\n Passagem: "+ p.getPassagem().getEmpresa()
					+"\n Embarque: "+ p.getPassagem().getEmbarque() 
					+"\n Data: "+ p.getPassagem().getData_passagem() 
					+"\n Valor Unitario : " + p.getPassagem().getValor_passagem()
					+"\n Valor Total : " + p.getTotal_Valor_item()
					+"\n -----------------------------------"
					);
		}
		
		for (ItemHospedagem h : compraH.getItensHospedagens()) {
			System.out.println("Qtd Diaria: " + h.getQtd_item()
					+"\n Hospedagem: "+ h.getHospedagem().getEmpresa()
					+"\n Endereco: "+ h.getHospedagem().getEndereco() 
					+"\n Data: "+ h.getHospedagem().getData_hospedagem() 
					+"\n Valor Unitario : " + h.getHospedagem().getValor_diaria()
					+"\n Valor Total : " + h.getTotal_Valor_item()
					+"\n -----------------------------------"
					);
		}
		
	}

}
