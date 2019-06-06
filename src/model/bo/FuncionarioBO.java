package model.bo;

import model.dao.FuncionarioDAO;
import model.vo.Funcionario;

public class FuncionarioBO {

	private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

	public boolean atualizar(Funcionario funcionario) {
		boolean sucesso = funcionarioDAO.atualizar(funcionario);
		return sucesso;
	}

	public boolean inserir(Funcionario funcionario) {
		int idGerado = funcionarioDAO.inserir(funcionario);
		return idGerado > 0;
	}
}
