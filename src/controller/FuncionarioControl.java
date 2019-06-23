package controller;

import java.util.ArrayList;

import model.bo.FuncionarioBO;
import model.vo.Funcionario;

public class FuncionarioControl {

	// Verificar se os campos são nulos ou vazios senao chamar BO

	private static final FuncionarioBO FuncionarioBO = new FuncionarioBO();

	public static String salvar(Funcionario funcionario) {
		String validacao = validarFuncionario(funcionario);

		if (validacao == "") {
			if (funcionario.getIdFuncionario() > 0) {
				if (FuncionarioBO.atualizar(funcionario)) {
					validacao = "Funcionário atualizado com sucesso!";
				} else {
					validacao = "Erro ao atualizar funcionário";
				}
			} else {
				if (FuncionarioBO.salvar(funcionario)) {
					validacao = "Funcionário salvo com sucesso!";
				} else {
					validacao = "Erro ao salvar Funcionário";
				}
			}
		}
		return validacao;
	}

	private static String validarFuncionario(Funcionario funcionario) {
		String validacao = "";

		if (funcionario == null) {
			validacao = "Funcionário está NULO!";
		} else {
			// Validar o preenchimento
			if (funcionario.getNome().trim().equals("")) {
				validacao += "- Nome é obrigatório \n";
			}
			if (funcionario.getCpf().trim().equals("")) {
				validacao += "- O CPF é obrigatório \n";
			}
		}
		return validacao;
	}

	public void excluir(Integer id) {
		FuncionarioBO funcionarioBO = new FuncionarioBO();
		funcionarioBO.excluir(id);

	}

	public ArrayList<Funcionario> listarTodosFuncionarios() {
		return null;
	}

}
