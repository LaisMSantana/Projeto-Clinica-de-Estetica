package model.bo;

import java.util.List;

import model.dao.AgendamentoDAO;
import model.util.GeradordePlanilha;
import model.vo.Agendamento;

public class AgendamentoBO {
	
	private GeradordePlanilha geradorPlanilha = new GeradordePlanilha();
	private AgendamentoDAO agendamentoDAO = new AgendamentoDAO();

	public boolean atualizar(Agendamento agendamento) {
		boolean sucesso = agendamentoDAO.atualizar(agendamento);
		return sucesso;
	}

	public boolean salvar(Agendamento agendamento) {
		int idGerado = agendamentoDAO.salvar(agendamento);
		return idGerado > 0;
	}

	public List<Agendamento> listarTodos() {
		AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
		return agendamentoDAO.listarTodos();
	}

	public boolean excluir(Agendamento agendamento) {
		int idGerado = agendamentoDAO.excluir(agendamento);
		return idGerado > 0;
	}
	
	public String gerarRelatorio(String caminhoArquivo) {
		if (!caminhoArquivo.toLowerCase().endsWith(".xlsx")) {
			caminhoArquivo += ".xlsx";
		}
		String mensagem = geradorPlanilha.gerarPlanilha(caminhoArquivo, agendamentoDAO.listarTodos());
		return mensagem;
		
	}
}
