package model.vo;

public class Procedimento {

	private int idProcedimento;
	private String nome;
	private int sala;

	public Procedimento() {
		super();
	}

	public Procedimento(int idProcedimento, String nome, int sala) {
		super();
		this.idProcedimento = idProcedimento;
		this.nome = nome;
		this.sala = sala;
	}

	public int getIdProcedimento() {
		return idProcedimento;
	}

	public void setIdProcedimento(int idProcedimento) {
		this.idProcedimento = idProcedimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getSala() {
		return sala;
	}

	public void setSala(int sala) {
		this.sala = sala;
	}

}
