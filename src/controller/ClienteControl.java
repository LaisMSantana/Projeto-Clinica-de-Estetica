package controller;

import java.util.ArrayList;

import model.bo.ClienteBO;
import model.vo.Cliente;

public class ClienteControl {
	// Verificar se os campos são nulos ou vazios senao chamar BO

	private static final ClienteBO clienteBO = new ClienteBO();

	public static String salvar(Cliente cliente) {
		String validacao = validarCliente(cliente);

		if (validacao == "") {
			validacao = clienteBO.filtroCliente(cliente);
			if (validacao == "") {
				if (cliente.getIdCliente() > 0) {
					if (clienteBO.atualizar(cliente)) {
						validacao = "Cliente atualizado com sucesso!";
					} else {
						validacao = "Erro ao atualizar Cliente";
					}
				} else {
					if (clienteBO.salvar(cliente)) {
						validacao = "Cliente salvo com sucesso!";
					} else {
						validacao = "Erro ao salvar Cliente";
					}
				}
			}
		}
		return validacao;
	}

	private static String validarCliente(Cliente cliente) {
		String validacao = "";

		if (cliente == null) {
			validacao = "Cliente está NULO!";
		} else {
			if (cliente.getNome().trim().equals("")) {
				validacao += "- Nome é obrigatório \n";
			}
			if (cliente.getCpf().trim().equals("")) {
				validacao += "- O CPF é obrigatório \n";
			}
		}
		return validacao;
	}

	public void excluir(Integer id) {
		ClienteBO clienteBO = new ClienteBO();
		clienteBO.excluir(id);
	}

	public ArrayList<Cliente> listarTodos() {
		return clienteBO.listarTodos(null, null);
	}

	public ArrayList<Cliente> listarTodos(String nome, String cpf) {
		return clienteBO.listarTodos(nome, cpf);
	}

}
