package crud;

import java.util.Scanner;

import dao.UsuarioDao;
import modelo.Logar;
import modelo.Permissao;
import modelo.Usuario;

public class CrudUsuario {

	public static void main(String[] args) {

		UsuarioDao usuarioDao = new UsuarioDao();
		Usuario usuario = new Usuario();
		Logar autenticar = new Logar();

		String nome = "";
		String email = "";
		String senha = "";
		String endereco = "";
		int id = 0;
		int opcao = 0;
		Scanner entrada = new Scanner(System.in);

		do {
		
			System.out.println("Bem vindo(a), escolha a opcao desejada! \n");
			System.out.println("1 - Cadastrar Usuario");
			System.out.println("2 - Atualizar Usuario");
			System.out.println("3 - Deletar Usuario");
			System.out.println("4 - Mostrar usuarios");
			System.out.println("5 - Para sair");
			opcao = entrada.nextInt();

			switch (opcao) {
			case 1:
				// Salvar usuario
				Permissao admUser = new Permissao(1, "Administrador");
				Permissao commUser = new Permissao(2, "usuarioComum");

				System.out.println("Digite seu nome \n");
				nome = entrada.next();
				
				System.out.println("Digite seu email \n");
				email = entrada.next();
				
				System.out.println("Digite sua senha \n");
				entrada.nextLine();
				senha = entrada.nextLine();
				
				System.out.println("Digite seu endereco \n");
				endereco = entrada.nextLine();

				Usuario cadastroUsuario = new Usuario(nome, email, senha, endereco, commUser);

				usuarioDao.saveUser(cadastroUsuario);

				System.out.println("Usuario cadastrado com sucesso! \n");

				break;
			case 2:
				// Atualizar usuario
				System.out.println("Digite sua senha \n");
				senha = entrada.next();
				System.out.println("Digite seu email \n");
				email = entrada.next();

				autenticar = usuarioDao.validarUsuario(senha, email);

				if (senha.equals(autenticar.getSenha()) && email.equals(autenticar.getEmail())) {
					System.out.println("Digite UM NOVO NOME \n");
					entrada.nextLine();
					nome = entrada.nextLine();
					System.out.println("Digite UM NOVO ENDERECO \n");
					endereco = entrada.nextLine();

					usuario.setNome(nome);
					usuario.setEndereco(endereco);
					usuario.setEmail(email);
					usuario.setSenha(senha);
					usuarioDao.updateUser(usuario);
				} else {
					System.out.println("Erro, Senha ou usuario não cadastrado \n");
					System.out.println("Falha na atualização");
				}

				break;
			case 3:
				// Deletar usuario
				System.out.println("Digite o id do usuario para excluir");
				id = entrada.nextInt();
				usuarioDao.deleteUser(id);
				break;
			case 4:
				//Mostrar usuarios
				for(Usuario user : usuarioDao.readUser()) {
					System.out.println("Id: " + user.getId_usuario() + "\n Nome: " + user.getNome() 
					+ "\n Endereco: " + user.getEndereco()
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
