package model.bo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import controller.ClienteControl;
import model.dao.ClienteDAO;
import model.vo.Cliente;

public class ClienteBO {

	ClienteDAO clienteDAO = new ClienteDAO();

	public boolean atualizar(Cliente cliente) {
		boolean sucesso = clienteDAO.atualizar(cliente);
		return sucesso;
	}

	public boolean salvar(Cliente cliente) {
		int idGerado = clienteDAO.salvar(cliente);
		return idGerado > 0;
	}

	public void excluir(Integer id) {
		clienteDAO.excluir(id);
	}

	public ArrayList<Cliente> listarTodos(String nome, String cpf) {
		return clienteDAO.listarTodos(nome, cpf);
	}

}
