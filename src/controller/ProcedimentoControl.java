package controller;

import model.bo.ProcedimentoBO;
import model.vo.Procedimento;

public class ProcedimentoControl {
	// Verificar se os campos são nulos ou vazios senao chamar BO
	private static final ProcedimentoBO cadastroProcedimentoBO = new ProcedimentoBO();

	public static String salvar(String nome, String sala) {
		String mensagem = "";
		if (nome == null || nome.trim().isEmpty()) {
			mensagem += "Erro por favor digite um nome, e sem espaço \n";
		}
		if (sala == null || sala.trim().isEmpty()) {
			mensagem += "Erro por favor digite uma sala, e sem espaço \n";
		}
		// validar o preenchimento dos campos - nao nulos e nao vazios
		if (mensagem.isEmpty()) {
			Procedimento procedimento = new Procedimento();
			procedimento.setNome(nome);
			procedimento.setSala(sala);
			cadastroProcedimentoBO.salvar(procedimento);
			return null;
		}
		return mensagem;
	}

	public static boolean close() {
		return false;
	}

}
