package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;
import conexao.ConexaoMysql;
import modelo.Logar;
import modelo.Permissao;
import modelo.Usuario;

public class UsuarioDao {

	Connection conn = null;
	PreparedStatement pstm = null;

	// Salvar usuario
	public void saveUser(Usuario usuario) {
		Permissao permissao = new Permissao();
		String sql = "INSERT INTO usuario(nome, email, senha, endereco)" + "VALUES(?, ?, ?, ?);";

		try {
			conn = ConexaoMysql.createConnectionToMySQL();
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

	// Ler dados do usuario
	public List<Usuario> readUser() {

		List<Usuario> userData = new ArrayList<Usuario>();
		String sql = "SELECT * FROM usuario;";
		ResultSet rset = null;

		try {
			conn = ConexaoMysql.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				Usuario user = new Usuario();
				user.setId_usuario(rset.getInt("id_usuario"));
				user.setNome(rset.getString("nome"));
				user.setEndereco(rset.getString("endereco"));
				userData.add(user);

			}
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

		return userData;
	}

	// Atualizar dados do usuario
	public void updateUser(Usuario usuario) {
		String sql = "UPDATE usuario SET nome = ?, endereco = ? " + " WHERE senha = ? AND email = ?;";

		try {
			conn = ConexaoMysql.createConnectionToMySQL();
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

	//Deletar usuario
	public void deleteUser(int id) {
		String sql = "DELETE FROM usuario" + " WHERE id_usuario = ?";

		try {
			conn = ConexaoMysql.createConnectionToMySQL();
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
			conn = ConexaoMysql.createConnectionToMySQL();
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
	
	
	public Usuario getUser(String senha, String email) {
		Usuario usuario = new Usuario();
		String sql = "SELECT * FROM usuario WHERE senha = ? AND email = ?";
		
		ResultSet rset = null;

		try {
			conn = ConexaoMysql.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, senha);
			pstm.setString(2, email);
			rset = pstm.executeQuery();

			rset.next();
			
			usuario.setId_usuario(rset.getInt("id_usuario"));
			usuario.setNome(rset.getString("nome"));
			usuario.setEmail(rset.getString("email"));
			
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
