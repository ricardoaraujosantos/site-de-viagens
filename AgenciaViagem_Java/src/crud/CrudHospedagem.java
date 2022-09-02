package crud;

import java.util.Scanner;

import dao.HospedagemDao;
import modelo.Hospedagem;

public class CrudHospedagem {

	public static void main(String[] args) {
		HospedagemDao hospedagemDao = new HospedagemDao();
		Hospedagem hospedagem = new Hospedagem();

		String empresa = "";
		String endereco = "";
		double valorDiaria = 0;
		String dataHospedagem = "";
		int id = 0;
		int opcao = 0;
		Scanner entrada = new Scanner(System.in);

		do {

			System.out.println("Bem vindo(a) ao cadastro de hospedagem, escolha a opcao desejada! \n");
			System.out.println("1 - Cadastrar Hospedagem");
			System.out.println("2 - Atualizar Hospedagem");
			System.out.println("3 - Deletar Hospedagem");
			System.out.println("4 - Mostrar Hospedagem");
			System.out.println("5 - Para sair");
			opcao = entrada.nextInt();

			switch (opcao) {
			case 1:
				// Salvar hospedagem
				System.out.println("Cadastrar Hospedagem \n");
				System.out.println("Digite o nome da empresa \n");
				empresa = entrada.next();

				System.out.println("Digite o endereco \n");
				endereco = entrada.next();

				System.out.println("Digite o valor da Hospedagem");
				valorDiaria = entrada.nextDouble();

				System.out.println("Digite a data da Hospedagem");
				dataHospedagem = entrada.next();

				Hospedagem hospedagemCadastro = new Hospedagem(empresa, endereco, valorDiaria, dataHospedagem);
				hospedagemDao.saveHosting(hospedagemCadastro);

				System.out.println("Passagem cadastrada com sucesso! \n");

				break;
			case 2:
				// Atualizar hospedagem

				System.out.println("--- Atualizar Hospedagem ----");
				System.out.println("Digite o id da hospedagem");
				id = entrada.nextInt();

				System.out.println("Atualizar Hospedagem \n");
				System.out.println("Digite o nome da empresa \n");
				empresa = entrada.next();

				System.out.println("Digite o endereco \n");
				endereco = entrada.next();

				System.out.println("Digite o valor da Hospedagem");
				valorDiaria = entrada.nextDouble();

				System.out.println("Digite a data da Hospedagem");
				dataHospedagem = entrada.next();

				hospedagem.setEmpresa(empresa);
				hospedagem.setEndereco(endereco);
				hospedagem.setValor_diaria(valorDiaria);
				hospedagem.setData_hospedagem(dataHospedagem);
				hospedagem.setId_hospedagem(id);

				hospedagemDao.updateHosting(hospedagem);
				break;
			case 3:
				// Deletar hospedagem
				System.out.println("Digite o id do usuario para excluir");
				id = entrada.nextInt();
				hospedagemDao.deleteHosting(id);
				break;
			case 4:
				// Mostrar Hospedagem
				for(Hospedagem h : hospedagemDao.readHosting()) {
						System.out.println("Id: " + h.getId_hospedagem() 
						+ "\n Empresa: " + h.getEmpresa() 
						+ "\n Endereco: " + h.getEndereco() 
						+ "\n Valor: " + h.getValor_diaria() 
						+ "\n Data: " + h.getData_hospedagem()
						+ "\n ------------------------------------------------------------------------");
				}
				break;
			case 5:
				System.out.println("Fim do Cadastro");

				break;

			default:
				System.out.println(opcao + " - Opcao invalida! \n");
			}

		} while (opcao != 5);
		entrada.close();
	}

}
