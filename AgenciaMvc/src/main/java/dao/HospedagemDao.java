package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.connection;
import model.Hospedagem;

public class HospedagemDao {
	Connection conn = null;
	PreparedStatement pstm = null;

	// Salvar passagem
	public void saveHosting(Hospedagem hospedagem) {

		String sql = "INSERT INTO hospedagem (empresa, endereco, valor_diaria, data_hospedagem, imagem)"
				+ "VALUES(?, ?, ?, ?, ?);";

		try {
			conn = connection.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, hospedagem.getEmpresa());
			pstm.setString(2, hospedagem.getEndereco());
			pstm.setDouble(3, hospedagem.getValor_diaria());
			pstm.setString(4, hospedagem.getData_hospedagem());
			pstm.setString(5, hospedagem.getImagem());
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

	// Ler dados das passagens
	public List<Hospedagem> readHosting() {

		List<Hospedagem> hostingData = new ArrayList<Hospedagem>();
		String sql = "SELECT * FROM hospedagem;";
		ResultSet rset = null;

		try {
			conn = connection.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				Hospedagem hosting = new Hospedagem();
				hosting.setId_hospedagem(rset.getInt("id_hospedagem"));
				hosting.setEmpresa(rset.getString("empresa"));
				hosting.setEndereco(rset.getString("endereco"));
				hosting.setValor_diaria(rset.getDouble("valor_diaria"));
				hosting.setData_hospedagem(rset.getString("data_hospedagem"));
				hosting.setImagem(rset.getString("imagem"));

				hostingData.add(hosting);

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

		return hostingData;
	}

	// Atualizar dados da hospedagem
	public void updateHosting(Hospedagem hospedagem) {
		String sql = "UPDATE hospedagem SET empresa = ?, endereco = ?, valor_diaria = ?, data_hospedagem = ?, imagem = ? "
				+ " WHERE id_hospedagem = ?;";

		try {
			conn = connection.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, hospedagem.getEmpresa());
			pstm.setString(2, hospedagem.getEndereco());
			pstm.setDouble(3, hospedagem.getValor_diaria());
			pstm.setString(4, hospedagem.getData_hospedagem());
			pstm.setString(5, hospedagem.getImagem());
			pstm.setInt(6, hospedagem.getId_hospedagem());
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

	// Deletar hospedagem
	public void deleteHosting(int id) {
		String sql = "DELETE FROM hospedagem" + " WHERE id_hospedagem = ?";

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

	public Hospedagem getHostingById(int id) {
		Hospedagem hospedagem = new Hospedagem();

		String sql = "SELECT * FROM hospedagem WHERE id_hospedagem = ?;";

		ResultSet rset = null;

		try {
			conn = connection.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);

			rset = pstm.executeQuery();

			rset.next();

			hospedagem.setId_hospedagem(rset.getInt("id_hospedagem"));
			hospedagem.setEmpresa(rset.getString("empresa"));
			hospedagem.setEndereco(rset.getString("endereco"));
			hospedagem.setData_hospedagem(rset.getString("data_hospedagem"));
			hospedagem.setValor_diaria(rset.getDouble("valor_diaria"));
			hospedagem.setImagem(rset.getString("imagem"));

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
		return hospedagem;
	}
}
