package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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

	public ArrayList<Cliente> listarTodos() {
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		Connection conexao = Banco.getConnection();
		Statement stmt = Banco.getStatement(conexao);
		try {
			ResultSet rs = stmt.executeQuery("SELECT " + "CLIENTE.IDCLIENTE," + "CLIENTE.NOME," + "CLIENTE.ENDERECO,"
					+ "CLIENTE.BAIRRO," + "CLIENTE.CEP," + "CLIENTE.MUNICIPIO," + "CLIENTE.ESTADO,"
					+ "CLIENTE.TELEFONE," + "CLIENTE.CELULAR," + "CLIENTE.EMAIL," + "CLIENTE.CPF,"
					+ "CLIENTE.DATANASCIMENTO" + "FROM CLIENTE");

			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setIdCliente(rs.getInt(1));
				cliente.setNome(rs.getString(2));
				cliente.setEndereco(rs.getString(3));
				cliente.setBairro(rs.getString(4));
				cliente.setCep(rs.getString(5));
				cliente.setMunicipio(rs.getString(6));
				cliente.setEstado(rs.getString(7));
				cliente.setTelefone(rs.getString(8));
				cliente.setCelular(rs.getString(9));
				cliente.setEmail(rs.getString(10));
				cliente.setCpf(rs.getString(11));
				cliente.setDataDeNascimento(rs.getString(12));
				clientes.add(cliente);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao inserir Cliente. Causa: \n: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conexao);
		}
		return clientes;
	}

}
