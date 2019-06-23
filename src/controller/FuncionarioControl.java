package controller;

import java.util.ArrayList;

import model.bo.FuncionarioBO;
import model.vo.Funcionario;

public class FuncionarioControl {

	// Verificar se os campos s�o nulos ou vazios senao chamar BO

	private static final FuncionarioBO funcionarioBO = new FuncionarioBO();

	public static String salvar(Funcionario funcionario) {
		String validacao = validarFuncionario(funcionario);

		if (validacao == "") {
			if (funcionario.getIdFuncionario() > 0) {
				if (funcionarioBO.atualizar(funcionario)) {
					validacao = "Funcion�rio atualizado com sucesso!";
				} else {
					validacao = "Erro ao atualizar funcion�rio";
				}
			} else {
				if (funcionarioBO.salvar(funcionario)) {
					validacao = "Funcion�rio salvo com sucesso!";
				} else {
					validacao = "Erro ao salvar Funcion�rio";
				}
			}
		}
		return validacao;
	}

	private static String validarFuncionario(Funcionario funcionario) {
		String validacao = "";

		if (funcionario == null) {
			validacao = "Funcion�rio est� NULO!";
		} else {
			// Validar o preenchimento
			if (funcionario.getNome().trim().equals("")) {
				validacao += "- Nome � obrigat�rio \n";
			}
			if (funcionario.getCpf().trim().equals("")) {
				validacao += "- O CPF � obrigat�rio \n";
			}
		}
		return validacao;
	}

	public void excluir(Integer id) {
		FuncionarioBO funcionarioBO = new FuncionarioBO();
		funcionarioBO.excluir(id);

	}
	
	public ArrayList<Funcionario> listarTodos() {
		return funcionarioBO.listarTodos(null, null);
	}
	
	public ArrayList<Funcionario> listarTodos(String nome, String cargo) {
		return funcionarioBO.listarTodos(nome, cargo);
	}

	public ArrayList<Funcionario> listarTodosFuncionarios() {
		return null;
	}

}
