package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bo.AgendamentoBO;
import model.vo.Agendamento;

public class AgendamentoDAO {

	public boolean atualizar(Agendamento agendamento) {
		boolean sucessoUpdate = false;

		// ****REVISAR QUERY
		String sql = " UPDATE AGENDAMENTO agendamento SET NOME=?, CPF=?" + " WHERE FUNCIONARIO.ID = ? ";

		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao);

		try {
			prepStmt.setString(1, agendamento.getData());
			//prepStmt.setString(2, agendamento.getCliente());
		//	prepStmt.setDouble(3, funcionario.getIdFuncionario());

			int codigoRetorno = prepStmt.executeUpdate();

			if (codigoRetorno == 1) {
				sucessoUpdate = true;
			}

		} catch (SQLException e) {
			System.out.println("Erro ao atualizar Funcionário. Causa: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}

		return sucessoUpdate;
	}

	public int salvar(Agendamento agendamento) {
		int novoId = -1;

		String sql = " INSERT INTO AGENDAMENTO (DATA, IDPROCEDIMENTO,IDCLIENTE, IDFUNCIONARIO) " + " VALUES (?,?,?,?) ";

		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao);

		try {
			prepStmt.setString(1, agendamento.getData());
			prepStmt.setInt(2, agendamento.getProcedimento().getIdProcedimento());
			prepStmt.setInt(3, agendamento.getCliente().getIdCliente());
			prepStmt.setInt(4, agendamento.getFuncionario().getIdFuncionario());
			prepStmt.execute();

			ResultSet generatedKeys = prepStmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				novoId = generatedKeys.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao inserir Agendamento. Causa: \n: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}
		return novoId;
	}
	
	
	

	public ArrayList<AgendamentoBO> listarTodos() {
		return null;
	}

	public int excluir(Agendamento agendamento) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;

		String query = "DELETE FROM AGENDAMENTO WHERE IDAGENDAMENTO = " + agendamento.getIdAgendamento();
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Exclusão de Agendamento. Erro: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

}
