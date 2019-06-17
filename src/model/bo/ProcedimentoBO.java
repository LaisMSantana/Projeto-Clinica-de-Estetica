package model.bo;

import java.util.ArrayList;

import model.dao.ProcedimentoDAO;
import model.vo.Procedimento;

public class ProcedimentoBO {
	
	private ProcedimentoDAO procedimentoDAO = new ProcedimentoDAO();

	public  boolean salvar(Procedimento procedimento) {
		int idGerado = procedimentoDAO.salvar(procedimento);
		return idGerado > 0;
	}

	public boolean atualizar(Procedimento procedimento) {
		boolean sucesso = procedimentoDAO.atualizar(procedimento);
		return sucesso;
	}

	public String excluir(Procedimento procedimento) {
		String mensagem = "";
		ProcedimentoDAO procedimentoDAO = new ProcedimentoDAO();

		if (procedimentoDAO.existeProcedimentoNovo(procedimentoDAO) == false) {
			mensagem = "Procedimento inexistente";
		} else {
			int statusPersistencia = procedimentoDAO.excluir(procedimento);

			if (statusPersistencia == 1) {
				mensagem = "Procedimento excluido com sucesso";
			} else if (statusPersistencia == 0) {
				mensagem = "Erro ao excluir Procedimento";
			}
		}
		return mensagem;
	}

	public ArrayList<Procedimento> listarTodos() {
		ProcedimentoDAO procedimentoDAO = new ProcedimentoDAO();
		return procedimentoDAO.listarTodos();
	}
}
