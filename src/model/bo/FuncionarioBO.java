package model.bo;

import java.util.ArrayList;

import model.dao.FuncionarioDAO;
import model.vo.Funcionario;

public class FuncionarioBO {

	private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

	public boolean atualizar(Funcionario funcionario) {
		boolean sucesso = funcionarioDAO.atualizar(funcionario);
		return sucesso;
	}

	public boolean salvar(Funcionario funcionario) {
		int idGerado = funcionarioDAO.salvar(funcionario);
		return idGerado > 0;
	}

	public void excluir(Integer id) {
		funcionarioDAO.excluir(id);
	}

	public ArrayList<Funcionario> listarTodos(String nome, String cargo) {
		return funcionarioDAO.listarTodos(nome, cargo);
	}

	public String filtroFuncionario(Funcionario funcionario) {
		String mensagem = "";
		
		if(funcionario.getNome().length() < 3) {
			mensagem = "Nome incorreto! Mínimo 3 caracteres";
		} else if(funcionario.getEndereco().length() < 3) {
			mensagem = "Rua incorreta! Mínimo 3 caracteres";
		}else if(funcionario.getBairro().length() < 3) {
			mensagem = "Bairro incorreto! Mínimo 3 caracteres";
		}else if(funcionario.getMunicipio().length() < 3) {
			mensagem = "Município incorreto! Mínimo 3 caracteres";
		}else if(funcionario.getEstado().length() < 2) {
			mensagem = "Estado incorreto! Mínimo 2 caracteres";
		}else if((!emailCorreto(funcionario.getEmail())) || funcionario.getEmail().length() < 5) {
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