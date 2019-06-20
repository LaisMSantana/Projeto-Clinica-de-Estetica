package controller;

import java.util.ArrayList;

import model.bo.ClienteBO;
import model.vo.Cliente;

public class ClienteControl {

	// Verificar se os campos são nulos ou vazios senao chamar BO

	private static final ClienteBO ClienteBO = new ClienteBO();

	public static String salvar(Cliente cliente) {
		String validacao = validarCliente(cliente);

		if (validacao == "") {
			if (cliente.getIdCliente() > 0) {
				if (ClienteBO.atualizar(cliente)) {
					validacao = "Cliente atualizado com sucesso!";
				} else {
					validacao = "Erro ao atualizar Cliente";
				}
			} else {
				if (ClienteBO.salvar(cliente)) {
					validacao = "Cliente salvo com sucesso!";
				} else {
					validacao = "Erro ao salvar Cliente";
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
			// Validar o preenchimento
			if (cliente.getNome().trim().equals("")) {
				validacao += "- Nome é obrigatório \n";
			}
			if (cliente.getCpf().trim().equals("")) {
				validacao += "- O CPF é obrigatório \n";
			}
		}
		return validacao;
	}

	public String excluir(Cliente cliente, String nome, String cpf) {
		String mensagem = "";

		if (nome == null || nome.trim().isEmpty()) {
			mensagem = "Preenche o Nome";
		}
		if (cpf == null || cpf.trim().isEmpty()) {
			mensagem = "Preenche o Cpf";
		}
		if (mensagem.isEmpty()) {
			
			
			Cliente clienteExcluir = new Cliente();
			clienteExcluir.setNome(nome);
			clienteExcluir.setCpf(cpf);

			ClienteBO clienteBO = new ClienteBO();
			clienteBO.excluir(clienteExcluir);
		}
		return mensagem;
	}
	
}
