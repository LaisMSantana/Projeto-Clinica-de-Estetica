package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.vo.Cliente;

public class ClienteDAO {

	public boolean atualizar(Cliente cliente) {
		boolean sucessoUpdate = false;

		// ****REVISAR QUERY
		String sql = " UPDATE CLIENTE cliente SET NOME=?, CPF=?, TELEFONE=?, EMAIL=?" + " WHERE CLIENTE.ID = ? ";

		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);

		try {
			prepStmt.setString(1, cliente.getNome());
			prepStmt.setString(2, cliente.getCpf());
			prepStmt.setString(3, cliente.getTelefone());
			prepStmt.setString(4, cliente.getEmail());
			prepStmt.setDouble(5, cliente.getIdCliente());

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

	public int salvar(Cliente cliente) {
		int novoId = -1;

		String sql = " INSERT INTO CLIENTE (NOME," + "CPF," + "BAIRRO," + "CELULAR," + "CEP," + "DATANASCIMENTO,"
				+ "EMAIL," + "ENDERECO," + "ESTADO," + "MUNICIPIO," + "TELEFONE) " + " VALUES (?,?,?,?,?,?,?,?,?,?,?) ";

		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);

		try {
			prepStmt.setString(1, cliente.getNome());
			prepStmt.setString(2, cliente.getCpf().replace(".", "").replace("-", ""));
			prepStmt.setString(3, cliente.getBairro());
			prepStmt.setString(4, cliente.getCelular().replace("(", "").replace(")", "").replace("-", ""));
			prepStmt.setString(5, cliente.getCep().replace("-", ""));
			prepStmt.setDate(6, new java.sql.Date(cliente.getDataDeNascimento().getTime()));
			prepStmt.setString(7, cliente.getEmail());
			prepStmt.setString(8, cliente.getEndereco());
			prepStmt.setString(9, cliente.getEstado());
			prepStmt.setString(10, cliente.getMunicipio());
			prepStmt.setString(11, cliente.getTelefone().replace("(", "").replace(")", "").replace("-", ""));
			prepStmt.execute();

			ResultSet generatedKeys = prepStmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				novoId = generatedKeys.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao inserir Cliente. Causa: \n: " + e.getMessage());
			e.printStackTrace();
		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}
		return novoId;
	}

	public boolean existeClienteNovo(ClienteDAO clienteDAO) {
		return false;
	}

	public int excluir(Integer id) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;

		String query = "DELETE FROM CLIENTE WHERE IDCLIENTE = " + id;
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

	public ArrayList<Cliente> listarTodos(String nome, String cpf) {
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		Connection conexao = Banco.getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "SELECT IDCLIENTE, NOME, ENDERECO," + "BAIRRO,CEP,MUNICIPIO,ESTADO, "
					+ "TELEFONE,CELULAR,EMAIL,CPF, " + "DATANASCIMENTO FROM CLIENTE "
					+ "WHERE UPPER(NOME) LIKE ? AND CPF LIKE ? ";
			stmt = Banco.getPreparedStatement(conexao, sql);
			if (nome == null) {
				nome = "%%";
			} else {
				nome = "%" + nome.trim().toUpperCase() + "%";
			}
			if (cpf == null) {
				cpf = "%%";
			} else {
				cpf = "%" + cpf.replace(".", "").replace("-", "").trim() + "%";
			}
			stmt.setString(1, nome);
			stmt.setString(2, cpf);
			ResultSet rs = stmt.executeQuery();

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
				cliente.setDataDeNascimento(rs.getDate(12));
				clientes.add(cliente);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro ao inserir Cliente. Causa: \n: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conexao);
		}
		return clientes;
	}

}
