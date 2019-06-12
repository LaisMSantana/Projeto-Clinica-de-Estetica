package controller;

import model.bo.AgendamentoBO;
import model.vo.Agendamento;

public class AgendamentoControl {
	
	// Verificar se os campos s�o nulos ou vazios senao chamar BO

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
			validacao = "Agendamento est� NULO!";
		} else {
			if (agendamento.getData().trim().equals("") || agendamento.getData() == null) {
				validacao += "- Data � obrigat�rio \n";
			}
			if (agendamento.getProcedimento().getNome().trim().equals("") || agendamento.getProcedimento().getNome() == null) {
				validacao += "- O Nome do Procedimento � obrigat�rio \n";
			}
			if (agendamento.getFuncionario().getNome().trim().equals("") || agendamento.getFuncionario().getNome() == null) {
				validacao += "- O Nome do Funcion�rio � obrigat�rio \n";
			}
			if (agendamento.getCliente().getNome().trim().equals("") || agendamento.getCliente().getNome() == null) {
				validacao += "- O Nome do Cliente � obrigat�rio \n";
			}
			if (agendamento.getCliente().getCpf().trim().equals("") || agendamento.getCliente().getCpf() == null) {
				validacao += "- O Cpf � obrigat�rio \n";
			}
			if (agendamento.getProcedimento().getSala().trim().equals("") || agendamento.getProcedimento().getSala() == null) {
				validacao += "- A Sala � obrigat�ria \n";
			}
		}	
		return validacao;
	}

	

}
