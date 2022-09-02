package crud;

import java.util.Scanner;

import dao.PassagemDao;
import modelo.Passagem;


public class CrudPassagem {

	public static void main(String[] args) {
		PassagemDao passagemDao = new PassagemDao();
		Passagem passagem = new Passagem();
		
		String empresa = "";
		String embarque = "";
		String desembarque = "";
		String dataPassagem = "";
		double valorPassagem = 0;
		int id = 0;
		int opcao = 0;
		Scanner entrada = new Scanner(System.in);

		do {
		
			System.out.println("Bem vindo(a) ao cadastro de passagem, escolha a opcao desejada! \n");
			System.out.println("1 - Cadastrar passagem");
			System.out.println("2 - Atualizar passagem");
			System.out.println("3 - Deletar passagem");
			System.out.println("4 - Mostrar passagem");
			System.out.println("5 - Para sair");
			opcao = entrada.nextInt();

			switch (opcao) {
			case 1:
				// Salvar passagem
				System.out.println("Cadastrar Passagem \n");
				System.out.println("Digite o nome da empresa \n");
				empresa = entrada.next();
				
				System.out.println("Digite o local de embarque \n");
				embarque = entrada.next();
				
				System.out.println("Digite o local de desembarque \n");
				desembarque = entrada.next();
				
				System.out.println("Digite a data da passagem");
				dataPassagem = entrada.next();
				
				System.out.println("Digite o valor da passagem");
				valorPassagem = entrada.nextDouble();

				Passagem passagemCadastro = new Passagem(empresa, embarque,  desembarque, valorPassagem, dataPassagem);
				passagemDao.saveTicket(passagemCadastro);
				
				System.out.println("Passagem cadastrada com sucesso! \n");

				break;
			case 2:
				// Atualizar passagem
				
				System.out.println("--- Atualizar Passagem ----");
				System.out.println("Digite o id da passagem");
				id  = entrada.nextInt();
				
				System.out.println("\n Digite o nome da empresa");
				empresa = entrada.next();
				
				System.out.println("\n Digite o local de embarque");
				embarque = entrada.next();
				
				System.out.println("\n Digite o local de desembarque");
				desembarque = entrada.next();
				
				System.out.println("\n Digite a data da passagem");
				dataPassagem = entrada.next();
				
				System.out.println("\n Digite o valor da passagem");
				valorPassagem = entrada.nextDouble();
				
				passagem.setEmpresa(empresa);
				passagem.setEmbarque(embarque);
				passagem.setDesembarque(desembarque);
				passagem.setData_passagem(dataPassagem);
				passagem.setValor_passagem(valorPassagem);
				passagem.setId_passagem(id);
				
				passagemDao.updateTicket(passagem);
				break;
			case 3:
				// Deletar usuario
				System.out.println("Digite o id do usuario para excluir");
				id = entrada.nextInt();
				passagemDao.deleteTicket(id);
				break;
			case 4:
				//Mostrar usuarios
				for(Passagem p : passagemDao.readTicket()) {
					System.out.println("Id: " + p.getId_passagem() 
					+ "\n Empresa: " + p.getEmpresa() 
					+ "\n Embarque: " + p.getEmbarque()
					+ "\n Desembarque: " + p.getDesembarque()
					+ "\n Valor: " + p.getValor_passagem()
					+ "\n Data: " + p.getData_passagem()
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


