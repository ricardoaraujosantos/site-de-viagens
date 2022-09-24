package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.connection;
import model.Logar;
import model.Usuario;

public class UsuarioDao {

	Connection conn = null;
	PreparedStatement pstm = null;

	// Salvar usuario
	public void saveUser(Usuario usuario) {

		String sql = "INSERT INTO usuario(nome, email, senha, endereco)" + "VALUES(?, ?, ?, ?);";

		try {
			conn = connection.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, usuario.getNome());
			pstm.setString(2, usuario.getEmail());
			pstm.setString(3, usuario.getSenha());
			pstm.setString(4, usuario.getEndereco());
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	// Metodo para Ler
	public List<Usuario> readUsers() {
		String sql = "select * from usuario;";

		List<Usuario> Usuario = new ArrayList<Usuario>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = connection.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Usuario usuario = new Usuario();

				usuario.setId_usuario(rset.getInt("id_usuario"));

				usuario.setNome(rset.getString("nome"));

				usuario.setEmail(rset.getString("email"));

				usuario.setSenha(rset.getString("senha"));

				usuario.setEndereco(rset.getString("endereco"));

				Usuario.add(usuario);

			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return Usuario;
	}

	// Atualizar dados do usuario
	public void updateUser(Usuario usuario) {
		String sql = "UPDATE usuario SET nome = ?, endereco = ? " + " WHERE senha = ? AND email = ?;";

		try {
			conn = connection.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, usuario.getNome());
			pstm.setString(2, usuario.getEndereco());
			pstm.setString(3, usuario.getSenha());
			pstm.setString(4, usuario.getEmail());
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}

		}
	}

	// Deletar usuario
	public void deleteUser(int id) {
		String sql = "DELETE FROM usuario" + " WHERE id_usuario = ?";

		try {
			conn = connection.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public Logar validarUsuario(String senha, String email) {

		String sql = "SELECT * FROM usuario WHERE senha = ? AND email = ?";
		Logar logar = new Logar();

		ResultSet rset = null;

		try {
			conn = connection.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, senha);
			pstm.setString(2, email);
			rset = pstm.executeQuery();

			while (rset.next()) {
				logar.setSenha(rset.getString("senha"));
				logar.setEmail(rset.getString("email"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return logar;
	}

	public Usuario getUserById(int id) {
		Usuario usuario = new Usuario();
		String sql = "SELECT * FROM usuario WHERE id_usuario = ?;";

		ResultSet rset = null;

		try {
			conn = connection.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);

			rset = pstm.executeQuery();

			rset.next();

			usuario.setId_usuario(rset.getInt("id_usuario"));
			usuario.setNome(rset.getString("nome"));
			usuario.setSenha(rset.getString("senha"));
			usuario.setEmail(rset.getString("email"));
			usuario.setEndereco(rset.getString("endereco"));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return usuario;
	}

}
