package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bo.ClienteBO;
import model.vo.Cliente;

public class ClienteDAO {

	public static boolean atualizar(Cliente cliente) {
		boolean sucessoUpdate = false;

		// ****REVISAR QUERY
		String sql = " UPDATE CLIENTE cliente SET NOME=?, CPF=?" + " WHERE CLIENTE.ID = ? ";

		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);

		try {
			prepStmt.setString(1, cliente.getNome());
			prepStmt.setString(2, cliente.getCpf());
			prepStmt.setDouble(3, cliente.getIdCliente());

			int codigoRetorno = prepStmt.executeUpdate();

			if (codigoRetorno == 1) {
				sucessoUpdate = true;
			}

		} catch (SQLException e) {
			System.out.println("Erro ao atualizar Cliente. Causa: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}

		return sucessoUpdate;
	}

	public static int salvar(Cliente cliente) {
		int novoId = -1;

		String sql = " INSERT INTO CLIENTE (NOME, CPF) " + " VALUES (?,?) ";

		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);

		try {
			prepStmt.setString(1, cliente.getNome());
			prepStmt.setString(2, cliente.getCpf());

			prepStmt.execute();

			ResultSet generatedKeys = prepStmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				novoId = generatedKeys.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao inserir Cliente. Causa: \n: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}
		return novoId;
	}

	public boolean existeClienteNovo(ClienteDAO clienteDAO) {
		// TODO Auto-generated method stub
		return false;
	}

	public int excluir(Cliente cliente) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;

		String query = "DELETE FROM CLIENTE WHERE IDCLIENTE= " + cliente.getIdCliente();
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Exclusão do Cliente. Erro: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public ArrayList<ClienteBO> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}
}
