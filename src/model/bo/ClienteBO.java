package model.bo;

import model.dao.ClienteDAO;
import model.vo.Cliente;

public class ClienteBO {

	public boolean atualizar(Cliente cliente) {
		boolean sucesso = ClienteDAO.atualizar(cliente);
		return sucesso;
	}

	public boolean inserir(Cliente cliente) {
		int idGerado = ClienteDAO.inserir(cliente);
		return idGerado > 0;
	}

	public String excluir(Cliente cliente, Cliente clienteNovo) {
		String mensagem = "";
		ClienteDAO clienteDAO = new ClienteDAO();

		if (clienteDAO.existeClienteNovo(clienteDAO) == false) {
			mensagem = "Cliente inexistente";
		} else {
			int statusPersistencia = clienteDAO.excluir(cliente);

			if (statusPersistencia == 1) {
				mensagem = "Funcion�rio excluido com sucesso";
			} else if (statusPersistencia == 0) {
				mensagem = "Erro ao excluir Funcion�rio";
			}
		}
		return mensagem;
	}
}