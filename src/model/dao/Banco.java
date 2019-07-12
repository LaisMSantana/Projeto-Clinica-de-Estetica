package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Banco {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String BANCO = "DBCLINICA";
	private static final String CONEXAO = "jdbc:mysql://10.10.102.216:3306/" + BANCO
			+ "?useTimezone=true&serverTimezone=UTC";
	private static final String USUARIO = "clinica";
	private static final String SENHA = "clinica";

	public static Connection getConnection() {
		try {
			Connection conn = null;
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(CONEXAO, USUARIO, SENHA);
			return conn;
		} catch (ClassNotFoundException e) {
			System.out.println("Classe do Driver não foi encontrada. Causa: " + e.getMessage());
			return null;
		} catch (SQLException e) {
			System.out.println("Erro ao obter a Connection. Causa: " + e.getMessage());
			return null;
		}
	}

	public static void closeConnection(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("Problema no fechamento da conexão. Causa: " + e.getMessage());
		}
	}

	public static Statement getStatement(Connection conn) {
		try {
			Statement stmt = conn.createStatement();
			return stmt;
		} catch (SQLException e) {
			System.out.println("Erro ao obter o Statement. Causa: " + e.getMessage());
			return null;
		}
	}

	public static void closeStatement(Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			System.out.println("Problema no fechamento do Statement. Causa: " + e.getMessage());
		}
	}

	public static PreparedStatement getPreparedStatement(Connection conn, String sql) {
		try {
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			return stmt;
		} catch (Exception e) {
			System.out.println("Erro ao obter o PreparedStatement. Causa: " + e.getMessage());
			return null;
		}
	}

	public static void closePreparedStatement(Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			System.out.println("Problema no fechamento do PreparedStatement. Causa: " + e.getMessage());
		}
	}

	public static void closeResultSet(ResultSet result) {
		try {
			if (result != null) {
				result.close();
			}
		} catch (SQLException e) {
			System.out.println("Problema no fechamento do ResultSet. Causa: " + e.getMessage());
		}
	}

}
