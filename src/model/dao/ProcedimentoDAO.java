package model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import model.vo.Procedimento;



public class ProcedimentoDAO {
	public int cadastrarProcedimentoDAO(Procedimento procedimento) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int r = 0;

		String query = "INSERT INTO procedimento(nome,sala) VALUES ('" + procedimento.getNome()
				+ "', '" + procedimento.getSala()+ "'";
		try {
			r = stmt.executeUpdate(query);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		} finally {
			Banco.closeConnection(conn);
		}
		return r;
	}

}
