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

	public String filtroCliente(Cliente cliente) {
		String mensagem = "";
		
		if(cliente.getNome().length() < 3) {
			mensagem = "Nome incorreto! Mínimo 3 caracteres";
		} else if(cliente.getEndereco().length() < 3) {
			mensagem = "Rua incorreta! Mínimo 3 caracteres";
		}else if(cliente.getBairro().length() < 3) {
			mensagem = "Bairro incorreto! Mínimo 3 caracteres";
		}else if(cliente.getMunicipio().length() < 3) {
			mensagem = "Município incorreto! Mínimo 3 caracteres";
		}else if(cliente.getEstado().length() < 2) {
			mensagem = "Estado incorreto! Mínimo 2 caracteres";
		}else if((!emailCorreto(cliente.getEmail())) || cliente.getEmail().length() < 5) {
			mensagem = "Email incorreto!";
		}
		return mensagem;
	}
	
	private boolean emailCorreto(String emailInformado) {
		boolean emailCorreto = false;
		String[] partes = emailInformado.split("@");
		if(partes.length == 2) {
			emailCorreto = true;
		}
		return emailCorreto;
	}

}
