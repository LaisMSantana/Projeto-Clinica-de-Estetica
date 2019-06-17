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

	public String excluir(Agendamento agendamento) {
		String mensagem = "";
		AgendamentoDAO agendamentoDAO = new AgendamentoDAO();

		if (!agendamentoDAO.existeAgendamentoNovo(agendamentoDAO)) {
			mensagem = "Agendamento inexistente";
		} else {
			int statusPersistencia = agendamentoDAO.excluir(agendamento);

			if (statusPersistencia == 1) {
				mensagem = "Agendamento excluido com sucesso";
			} else if (statusPersistencia == 0) {
				mensagem = "Erro ao excluir Agendamento";
			}
		}
		return mensagem;
	}
	
	public List<Agendamento> listarTodos() {
		AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
		return agendamentoDAO.listarTodos();
	}

	public String gerarRelatorio(String caminhoArquivo) {
		if (!caminhoArquivo.toLowerCase().endsWith(".xlsx")) {
			caminhoArquivo += ".xlsx";
		}
		String mensagem = geradorPlanilha.gerarPlanilha(caminhoArquivo, agendamentoDAO.listarTodos());
		return mensagem;	
	}
}
