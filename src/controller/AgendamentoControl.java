package controller;

import model.bo.AgendamentoBO;
import model.vo.Agendamento;

public class AgendamentoControl {

	private static final AgendamentoBO AgendamentoBO = new AgendamentoBO(); 
	
	public static String salvar(Agendamento agendamento) {
		String validacao = validarAgendamento(agendamento);
		
		if (validacao == "") {
			if (agendamento.getIdAgendamento() > 0) {
				if (AgendamentoBO.atualizar(agendamento)) {
					validacao = "Agendamento atualizado com sucesso!";
				} else {
					validacao = "Erro ao atualizar agendamento";
				}
			} else {
				if (AgendamentoBO.salvar(agendamento)) {
					validacao = "Agendamento salvo com sucesso!";
				} else {
					validacao = "Erro ao salvar Agendamento";
				}
			}
		}
		return validacao;
	}

	private static String validarAgendamento(Agendamento agendamento) {
		String validacao = "";

		if (agendamento == null) {
			validacao = "Agendamento está NULO!";
		} else {
			if (agendamento.getData().trim().equals("") || agendamento.getData() == null) {
				validacao += "- Data é obrigatório \n";
			}
			if (agendamento.getProcedimento().getNome().trim().equals("") || agendamento.getProcedimento().getNome() == null) {
				validacao += "- O Procedimento é obrigatório \n";
			}
			if (agendamento.getFuncionario().getNome().trim().equals("") || agendamento.getFuncionario().getNome() == null) {
				validacao += "- O Procedimento é obrigatório \n";
			}
			if (agendamento.getCliente().getNome().trim().equals("") || agendamento.getCliente().getNome() == null) {
				validacao += "- O Procedimento é obrigatório \n";
			}
			if (agendamento.getCliente().getCnpjCpf().trim().equals("") || agendamento.getCliente().getCnpjCpf() == null) {
				validacao += "- O Procedimento é obrigatório \n";
			}
			if (agendamento.getProcedimento().getSala().trim().equals("") || agendamento.getProcedimento().getSala() == null) {
				validacao += "- O Procedimento é obrigatório \n";
			}
		}
		
		return validacao;
	}

	

}
