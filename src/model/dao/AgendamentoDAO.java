package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.vo.Agendamento;
import model.vo.Cliente;
import model.vo.Funcionario;
import model.vo.Procedimento;

public class AgendamentoDAO {

	public boolean atualizar(Agendamento agendamento) {
		boolean sucessoUpdate = false;

		// ****REVISAR QUERY
		String sql = " UPDATE AGENDAMENTO agendamento SET NOME=?, CPF=?" + " WHERE FUNCIONARIO.ID = ? ";

		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);

		try {
			// prepStmt.setString(1, agendamento.getData());
			// prepStmt.setString(2, agendamento.getCliente());
			// prepStmt.setDouble(3, funcionario.getIdFuncionario());

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
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);

		try {
			prepStmt.setDate(1, new java.sql.Date(agendamento.getData().getTime()));
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

	public List<Agendamento> listarTodos() {
		List<Agendamento> agendamentos = new ArrayList<Agendamento>();
		Connection conexao = Banco.getConnection();
		Statement stmt = Banco.getStatement(conexao);
		try {
			ResultSet rs = stmt.executeQuery(
					"SELECT "
					+ "AGENDAMENTO.IDAGENDAMENTO, "
					+ "AGENDAMENTO.DATA, "
					+ "CLIENTE.IDCLIENTE, "
					+ "CLIENTE.NOME, "
					+ "FUNCIONARIO.IDFUNCIONARIO, "
					+ "FUNCIONARIO.NOME, "
					+ "PROCEDIMENTO.IDPROCEDIMENTO, "
					+ "PROCEDIMENTO.NOME, "
					+ "PROCEDIMENTO.SALA "
					+ "FROM AGENDAMENTO "
					+ "JOIN CLIENTE ON AGENDAMENTO.IDCLIENTE = CLIENTE.IDCLIENTE "
					+ "JOIN FUNCIONARIO ON AGENDAMENTO.IDFUNCIONARIO = FUNCIONARIO.IDFUNCIONARIO "
					+ "JOIN PROCEDIMENTO ON AGENDAMENTO.IDPROCEDIMENTO = PROCEDIMENTO.IDPROCEDIMENTO ");
			
			while(rs.next()) {
				Agendamento agendamento = new Agendamento();
				agendamento.setIdAgendamento(rs.getInt(1));
				agendamento.setData(rs.getTimestamp(2));
				Cliente cliente = new Cliente();
				cliente.setIdCliente(rs.getInt(3));
				cliente.setNome(rs.getString(4));
				agendamento.setCliente(cliente);
				Funcionario funcionario = new Funcionario();
				funcionario.setIdFuncionario(rs.getInt(5));
				funcionario.setNome(rs.getString(6));
				agendamento.setFuncionario(funcionario);
				Procedimento procedimento = new Procedimento();
				procedimento.setIdProcedimento(rs.getInt(7));
				procedimento.setNome(rs.getString(8));
				procedimento.setSala(rs.getString(9));
				agendamento.setProcedimento(procedimento);
				agendamentos.add(agendamento);
			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao inserir Agendamento. Causa: \n: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conexao);
		}
		return agendamentos;
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
