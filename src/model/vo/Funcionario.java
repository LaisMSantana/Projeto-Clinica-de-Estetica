package model.vo;

public class Funcionario extends Pessoa {

	private int idFuncionario;
	private String cpf;
	private String rg;
	private String cargo;
	private String funcao;
	private String dataAdmissao;
	private String escolaridade;

	public Funcionario() {
		super();
	}

	public Funcionario(int idPessoa, String nome, String endereco, String bairro, String cep, String municipio,
			String estado, String telefone, String celular, String email, String dataDeNascimento) {
		super(idPessoa, nome, endereco, bairro, cep, municipio, estado, telefone, celular, email, dataDeNascimento);
	}

	public Funcionario(int idFuncionario, String cpf, String rg, String cargo, String funcao, String dataAdmissao,
			String escolaridade) {
		super();
		this.idFuncionario = idFuncionario;
		this.cpf = cpf;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public String getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(String dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public String getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}

}
