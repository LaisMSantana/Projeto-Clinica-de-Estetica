package model.bo;

import java.util.ArrayList;

import model.dao.ClienteDAO;
import model.vo.Cliente;

public class ClienteBO {


	public boolean atualizar(Cliente cliente) {
		boolean sucesso = ClienteDAO.atualizar(cliente);
		return sucesso;
	}

	public boolean salvar(Cliente cliente) {
		int idGerado = ClienteDAO.salvar(cliente);
		return idGerado > 0;
	}

	public String excluir(Cliente cliente) {
		String mensagem = "";
		ClienteDAO clienteDAO = new ClienteDAO();

		if (clienteDAO.existeClienteNovo(clienteDAO) == false) {
			mensagem = "Cliente inexistente";
		} else {
			int statusPersistencia = clienteDAO.excluir(cliente);

			if (statusPersistencia == 1) {
				mensagem = "Funcionário excluido com sucesso";
			} else if (statusPersistencia == 0) {
				mensagem = "Erro ao excluir Funcionário";
			}
		}
		return mensagem;
	}

	public ArrayList<Cliente> listarTodos() {
		ClienteDAO clienteDAO = new ClienteDAO();
		return clienteDAO.listarTodos();
	}

	
}
