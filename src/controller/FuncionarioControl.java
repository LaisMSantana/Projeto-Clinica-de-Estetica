package controller;

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
					validacao = "Funcionario atualizado com sucesso!";
				} else {
					validacao = "Erro ao atualizar produto";
				}
			} else {
				if (FuncionarioBO.inserir(funcionario)) {
					validacao = "Funcionario salvo com sucesso!";
				} else {
					validacao = "Erro ao salvar Funcionario";
				}
			}
		}
		return validacao;
	}

	private static String validarFuncionario(Funcionario funcionario) {
		String validacao = "";

		if (funcionario == null) {
			validacao = "Funcionario está NULO!";
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

	public static boolean close() {
		return false;

	}

}
