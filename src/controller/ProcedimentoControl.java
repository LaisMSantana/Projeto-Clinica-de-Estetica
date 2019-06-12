package controller;


import model.bo.ProcedimentoBO;
import model.vo.Procedimento;

public class ProcedimentoControl {

	// Verificar se os campos são nulos ou vazios senao chamar BO

	private static final ProcedimentoBO ProcedimentoBO = new ProcedimentoBO();

	public static String salvar(Procedimento procedimento) {
		String validacao = validarProcedimento(procedimento);
		
		if (validacao == "") {
			if (procedimento.getIdProcedimento() > 0) {
				if (ProcedimentoBO.atualizar(procedimento)) {
					validacao = "Procedimento atualizado com sucesso!";
				} else {
					validacao = "Erro ao atualizar Procedimento";
				}
			} else {
				if (ProcedimentoBO.salvar(procedimento)) {
					validacao = "Procedimento salvo com sucesso!";
				} else {
					validacao = "Erro ao salvar Procedimento";
				}
			}
		}
		return validacao;
	}

	private static String validarProcedimento(Procedimento procedimento) {
		String validacao = "";

		if (procedimento == null) {
			validacao = "Procedimento está NULO!";
		} else {
			// Validar o preenchimento
			if (procedimento.getNome().trim().equals("")) {
				validacao += "- Nome é obrigatório \n";
			}
			if (procedimento.getSala().trim().equals("")) {
				validacao += "- Sala é obrigatória \n";
			}
		}
		return validacao;
	}
	
	public String excluir(Procedimento procedimento, String nome, String sala) {
		String mensagem = "";

		if (nome == null || nome.trim().isEmpty()) {
			mensagem = "Preenche o nome";
		}
		if (sala == null || sala.trim().isEmpty()) {
			mensagem = "Preenche a sala";
		}
		if (mensagem.isEmpty()) {
				
			Procedimento procedimentoExcluir = new Procedimento();
			procedimentoExcluir.setNome(nome);
			procedimentoExcluir.setSala(sala);
			
			ProcedimentoBO procedimentoBO = new ProcedimentoBO();
			procedimentoBO.excluir(procedimentoExcluir);
		}
		return mensagem;
	}

	public static void salvar(String text, String text2) {
		// TODO Auto-generated method stub
		
	}

}
