package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.vo.Funcionario;

public class FuncionarioDAO {

	public int salvar(Funcionario funcionario) {
		int novoId = -1;

		String sql = " INSERT INTO FUNCIONARIO (NOME," 
				+ " CPF,"
				+ "BAIRRO,"
				+ "CARGO," 
				+ "CELULAR,"
				+ "CEP,"
				+ "EMAIL,"
				+ "ENDERECO,"
				+ "ESCOLARIDADE,"
				+ "ESTADO,"
				+ "FUNCAO,"
				+ "MUNICIPIO,"
				+ "TELEFONE) "
				+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?) ";

		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);

		try {
			prepStmt.setString(1, funcionario.getNome());
			prepStmt.setString(2, funcionario.getCpf().replace(".", "").replace("-", ""));
			prepStmt.setString(3, funcionario.getBairro());
			prepStmt.setString(4, funcionario.getCargo());
			prepStmt.setString(5, funcionario.getCelular().replace("(", "").replace(")", "").replace("-", ""));
			prepStmt.setString(6, funcionario.getCep().replace("-", ""));
			prepStmt.setString(7, funcionario.getEmail());
			prepStmt.setString(8, funcionario.getEndereco());
			prepStmt.setString(9, funcionario.getEscolaridade());
			prepStmt.setString(10, funcionario.getEstado());
			prepStmt.setString(11, funcionario.getFuncao());
			prepStmt.setString(12, funcionario.getMunicipio());
			prepStmt.setString(13, funcionario.getTelefone().replace("(", "").replace(")", "").replace("-", ""));

			prepStmt.execute();

			ResultSet generatedKeys = prepStmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				novoId = generatedKeys.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao inserir Funcionário. Causa: \n: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}
		return novoId;
	}

	public boolean atualizar(Funcionario funcionario) {
		boolean sucessoUpdate = false;

		// ****REVISAR QUERY
		String sql = " UPDATE FUNCIONARIO funcionario SET NOME=?, CARGO=?" + " WHERE FUNCIONARIO.ID = ? ";

		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);

		try {
			prepStmt.setString(1, funcionario.getNome());
			prepStmt.setString(2, funcionario.getCargo());
			prepStmt.setDouble(3, funcionario.getIdFuncionario());

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

	public boolean existeFuncionarioNovo(Integer id) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT * FROM FUNCIONARIO WHERE IDFUNCIONARIO = " + id;
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()){
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query que "
					+ "verifica existência de Funcionario por ID. Erro:"
					+ e.getMessage());
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	public int excluir(Integer id) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;

		String query = "DELETE FROM FUNCIONARIO WHERE IDFUNCIONARIO = " + id;
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Exclusão do Funcionário. Erro: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public ArrayList<Funcionario> listarTodos(String nome, String cargo) {
		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
		Connection conexao = Banco.getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "SELECT IDFUNCIONARIO, "
					+ "NOME,"
					+ " ENDERECO,"
					+ "BAIRRO,"
					+ " CEP,"
					+ " MUNICIPIO,"
					+ " ESTADO,"
					+ " TELEFONE,"
					+ " CELULAR,"
					+ " EMAIL,"
					+ " CPF,"
					+ " DATANASCIMENTO,"
					+ " RG,"
					+ " CARGO,"
					+ " FUNCAO,"
					+ " DATAADMISSAO,"
					+ " ESCOLARIDADE FROM FUNCIONARIO WHERE UPPER(NOME) LIKE ? ";
			if (cargo != null && cargo.trim().length() > 0) {
				sql += "AND UPPER(CARGO) LIKE ?";
			}
			
			stmt = Banco.getPreparedStatement(conexao, sql);
			
			if (nome == null) {
				nome = "%%";
			} else {
				nome = "%" + nome.trim().toUpperCase() + "%";
			}
			stmt.setString(1, nome);
			
			if (cargo != null && cargo.trim().length() > 0) {
				cargo = "%" + cargo.trim().toUpperCase() + "%";
				stmt.setString(2, cargo);
			}
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Funcionario funcionario = new Funcionario();
				funcionario.setIdFuncionario(rs.getInt(1));
				funcionario.setNome(rs.getString(2));
				funcionario.setEndereco(rs.getString(3));
				funcionario.setBairro(rs.getString(4));
				funcionario.setCep(rs.getString(5));
				funcionario.setMunicipio(rs.getString(6));
				funcionario.setEstado(rs.getString(7));
				funcionario.setTelefone(rs.getString(8));
				funcionario.setCelular(rs.getString(9));
				funcionario.setEmail(rs.getString(10));
				funcionario.setCpf(rs.getString(11));
				funcionario.setDataDeNascimento(rs.getDate(12));
				funcionario.setRg(rs.getString(13));
				funcionario.setCargo(rs.getString(14));
				funcionario.setFuncao(rs.getString(15));
				funcionario.setDataAdmissao(rs.getDate(16));
				funcionario.setEscolaridade(rs.getString(17));

				funcionarios.add(funcionario);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao inserir Funcionário. Causa: \n: " + e.getMessage());
			e.printStackTrace();
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conexao);
		}
		return funcionarios;
	}

}
