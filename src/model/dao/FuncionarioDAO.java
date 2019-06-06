package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.vo.Funcionario;

public class FuncionarioDAO {

	public boolean atualizar(Funcionario funcionario) {
		boolean sucessoUpdate = false;

		//****REVISAR QUERY 
		String sql = " UPDATE FUNCIONARIO funcionario SET NOME=?, CPF=?" + " WHERE FUNCIONARIO.ID = ? ";

		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao);

		try {
			prepStmt.setString(1, funcionario.getNome());
			prepStmt.setString(2, funcionario.getCpf());
			prepStmt.setDouble(3, funcionario.getIdFuncionario());

			int codigoRetorno = prepStmt.executeUpdate();

			if (codigoRetorno == 1) {
				sucessoUpdate = true;
			}

		} catch (SQLException e) {
			System.out.println("Erro ao atualizar funcionário. Causa: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}

		return sucessoUpdate;
	}

	public int inserir(Funcionario funcionario) {
		int novoId = -1;

		String sql = " INSERT INTO FUNCIONARIO (NOME, CPF) " + " VALUES (?,?) ";

		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao);

		try {
			prepStmt.setString(1, funcionario.getNome());
			prepStmt.setString(2, funcionario.getCpf());

			prepStmt.execute();

			ResultSet generatedKeys = prepStmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				novoId = generatedKeys.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao inserir funcionario. Causa: \n: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}
		return novoId;
	}
}
