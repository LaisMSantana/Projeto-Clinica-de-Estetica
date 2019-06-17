package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bo.ProcedimentoBO;
import model.vo.Procedimento;

public class ProcedimentoDAO {

	public int salvar(Procedimento procedimento) {
		int novoId = -1;

		String sql = " INSERT INTO PROCEDIMENTO (NOME, SALA) " + " VALUES (?,?) ";

		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);

		try {
			prepStmt.setString(1, procedimento.getNome());
			prepStmt.setString(2, procedimento.getSala());

			prepStmt.execute();

			ResultSet generatedKeys = prepStmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				novoId = generatedKeys.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao inserir Procedimento. Causa: \n: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}
		return novoId;
	}

	public boolean atualizar(Procedimento procedimento) {
		boolean sucessoUpdate = false;

		// ****REVISAR QUERY
		String sql = " UPDATE PROCEDIMENTO procedimento SET NOME=?, SALA=?" + " WHERE PROCEDIMENTO.ID = ? ";

		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);

		try {
			prepStmt.setString(1, procedimento.getNome());
			prepStmt.setString(2, procedimento.getSala());
			prepStmt.setDouble(3, procedimento.getIdProcedimento());

			int codigoRetorno = prepStmt.executeUpdate();

			if (codigoRetorno == 1) {
				sucessoUpdate = true;
			}

		} catch (SQLException e) {
			System.out.println("Erro ao atualizar Procedimento. Causa: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}

		return sucessoUpdate;
	}

	public boolean existeProcedimentoNovo(ProcedimentoDAO procedimentoDAO) {
		// TODO Auto-generated method stub
		return false;
	}

	public int excluir(Procedimento procedimento) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;

		String query = "DELETE FROM PROCEDIMENTO WHERE IDPROCEDIMENTO = " + procedimento.getIdProcedimento();
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Exclusão do Procedimento. Erro: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public ArrayList<ProcedimentoBO> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}
}
