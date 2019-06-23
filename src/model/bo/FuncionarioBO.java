package model.bo;

import java.util.ArrayList;

import model.dao.FuncionarioDAO;
import model.vo.Funcionario;

public class FuncionarioBO {

	private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

	public boolean atualizar(Funcionario funcionario) {
		boolean sucesso = funcionarioDAO.atualizar(funcionario);
		return sucesso;
	}

	public boolean salvar(Funcionario funcionario) {
		int idGerado = funcionarioDAO.salvar(funcionario);
		return idGerado > 0;
	}

	public void excluir(Integer id) {
		funcionarioDAO.excluir(id);
	}

	public ArrayList<Funcionario> listarTodos(String nome, String cargo) {
		return funcionarioDAO.listarTodos(nome, cargo);
	}

}
