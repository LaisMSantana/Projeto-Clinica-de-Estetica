package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
		return 0;
	}

	public ArrayList<AgendamentoBO> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
