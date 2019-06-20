package model.vo;

import java.util.Date;

public class Funcionario extends Pessoa {

	private int idFuncionario;
	private String rg;
	private String cargo;
	private String funcao;
	private Date dataAdmissao;
	private String escolaridade;

	public Funcionario() {
		super();
	}

	public Funcionario(int idFuncionario, String rg, String cargo, String funcao, Date dataAdmissao,
			String escolaridade) {
		super();
		this.idFuncionario = idFuncionario;
		this.rg = rg;
		this.cargo = cargo;
		this.funcao = funcao;
		this.dataAdmissao = dataAdmissao;
		this.escolaridade = escolaridade;
	}

	public int getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public String getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}

}