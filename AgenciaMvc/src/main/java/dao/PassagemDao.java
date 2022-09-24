package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.connection;
import model.Passagem;

public class PassagemDao {
	Connection conn = null;
	PreparedStatement pstm = null;

	// Salvar passagem
	public void saveTicket(Passagem passagem) {

		String sql = "INSERT INTO passagem(empresa, embarque, desembarque, valor_passagem, data_passagem)"
				+ "VALUES(?, ?, ?, ?, ?);";

		try {
			conn = connection.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, passagem.getEmpresa());
			pstm.setString(2, passagem.getEmbarque());
			pstm.setString(3, passagem.getDesembarque());
			pstm.setDouble(4, passagem.getValor_passagem());
			pstm.setString(5, passagem.getData_passagem());
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
	public List<Passagem> readTicket() {

		List<Passagem> ticketData = new ArrayList<Passagem>();
		String sql = "SELECT * FROM passagem;";
		ResultSet rset = null;

		try {
			conn = connection.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				Passagem ticket = new Passagem();
				ticket.setId_passagem(rset.getInt("id_passagem"));
				ticket.setEmpresa(rset.getString("empresa"));
				ticket.setEmbarque(rset.getString("embarque"));
				ticket.setDesembarque(rset.getString("desembarque"));
				ticket.setValor_passagem(rset.getDouble("valor_passagem"));
				ticket.setData_passagem(rset.getString("data_passagem"));

				ticketData.add(ticket);

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

		return ticketData;
	}

	// Atualizar dados da passagem
	public void updateTicket(Passagem passagem) {
		String sql = "UPDATE passagem SET empresa = ?, embarque = ?, desembarque = ?, valor_passagem = ?, data_passagem = ?"
				+ " WHERE id_passagem = ?;";

		try {
			conn = connection.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, passagem.getEmpresa());
			pstm.setString(2, passagem.getEmbarque());
			pstm.setString(3, passagem.getDesembarque());
			pstm.setDouble(4, passagem.getValor_passagem());
			pstm.setString(5, passagem.getData_passagem());
			pstm.setInt(6, passagem.getId_passagem());
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

	// Deletar passagem
	public void deleteTicket(int id) {
		String sql = "DELETE FROM passagem" + " WHERE id_passagem = ?";

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

	public Passagem getTicketById(int id) {
		Passagem passagem = new Passagem();

		String sql = "SELECT * FROM passagem WHERE id_passagem = ?;";

		ResultSet rset = null;

		try {
			conn = connection.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);

			rset = pstm.executeQuery();

			rset.next();

			passagem.setId_passagem(rset.getInt("id_passagem"));
			passagem.setEmpresa(rset.getString("empresa"));
			passagem.setEmbarque(rset.getString("embarque"));
			passagem.setDesembarque(rset.getString("desembarque"));
			passagem.setData_passagem(rset.getString("data_passagem"));
			passagem.setValor_passagem(rset.getDouble("valor_passagem"));

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
		return passagem;
	}

}
