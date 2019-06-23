package controller;

import java.time.LocalDate;
import java.util.List;

import model.bo.AgendamentoBO;
import model.vo.Agendamento;

public class AgendamentoControl {

	// Verificar se os campos são nulos ou vazios senao chamar BO

	private AgendamentoBO agendamentoBO = new AgendamentoBO(); 

	public String salvar(Agendamento agendamento) {
		String validacao = validarAgendamento(agendamento);

		if (validacao == "") {
			if (agendamento.getIdAgendamento() > 0) {
				if (agendamentoBO.atualizar(agendamento)) {
					validacao = "Agendamento atualizado com sucesso!";
				} else {
					validacao = "Erro ao atualizar agendamento";
				}
			} else {
				if (agendamentoBO.salvar(agendamento)) {
					validacao = "Agendamento salvo com sucesso!";
				} else {
					validacao = "Erro ao salvar Agendamento";
				}
			}
		}
		return validacao;
	}

	private String validarAgendamento(Agendamento agendamento) {
		String validacao = "";

		if (agendamento == null) {
			validacao = "Agendamento está NULO!";
		} else {
			if (agendamento.getData() == null) {
				validacao += "- Data é obrigatório \n";
			}
			if (agendamento.getProcedimento() == null) {
				validacao += "- O Nome do Procedimento é obrigatório \n";
			}
			if (agendamento.getFuncionario() == null) {
				validacao += "- O Nome do Funcionário é obrigatório \n";
			}
			if (agendamento.getCliente() == null) {
				validacao += "- O Nome do Cliente é obrigatório \n";
			}
		}	
		return validacao;
	}

	private String excluirAgendamento(Agendamento agendamento) {
		String mensagem = "";
		if (agendamento == null) {
			mensagem = "Selecione um agendamento";
		} else {
			mensagem = agendamentoBO.excluir(agendamento);
		} 
		return mensagem;
	}

	public List<Agendamento> listarTodosAgendamentos(String nomeCliente, LocalDate dataSelecionada) {
		AgendamentoBO agendamentoBO = new AgendamentoBO();
		return agendamentoBO.listarTodos(nomeCliente, dataSelecionada);
	}


	public String gerarRelatorio(String caminhoArquivo, String nomeCliente, LocalDate dataSelecionada) {
		return agendamentoBO.gerarRelatorio(caminhoArquivo, nomeCliente, dataSelecionada);
	}
}
