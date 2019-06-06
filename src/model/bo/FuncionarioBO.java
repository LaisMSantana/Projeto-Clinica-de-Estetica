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

	public String excluir(Funcionario funcionario, Funcionario funcionarioNovo) {
		String mensagem = "";
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

		if (funcionarioDAO.existeFuncionarioNovo(funcionarioNovo) == false) {
			mensagem = "Funcionário inexistente";
		} else {
			int statusPersistencia = funcionarioDAO.excluir(funcionario);

			if (statusPersistencia == 1) {
				mensagem = "Funcionário excluido com sucesso";
			} else if (statusPersistencia == 0) {
				mensagem = "Erro ao excluir Funcionário";
			}
		}
		return mensagem;
	}
}
