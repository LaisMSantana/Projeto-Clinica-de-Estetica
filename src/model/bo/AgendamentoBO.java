package model.bo;

import java.util.ArrayList;

import model.dao.AgendamentoDAO;
import model.vo.Agendamento;

public class AgendamentoBO {
	
	private AgendamentoDAO agendamentoDAO = new AgendamentoDAO();

	public boolean atualizar(Agendamento agendamento) {
		boolean sucesso = agendamentoDAO.atualizar(agendamento);
		return sucesso;
	}

	public boolean salvar(Agendamento agendamento) {
		int idGerado = agendamentoDAO.salvar(agendamento);
		return idGerado > 0;
	}

	public ArrayList<AgendamentoBO> listarTodos() {
		AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
		return agendamentoDAO.listarTodos();
	}
}
