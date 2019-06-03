package model.vo;

public class Cliente extends Pessoa {

	private int idCliente;
	private String cnpjCpf;

	public Cliente() {
		super();
	}

	public Cliente(int idPessoa, String nome, String endereco, String bairro, String cep, String municipio,
			String estado, String telefone, String celular, String email, String dataDeNascimento) {
		super(idPessoa, nome, endereco, bairro, cep, municipio, estado, telefone, celular, email, dataDeNascimento);
	}

	public Cliente(int idCliente, String cnpjCpf) {
		super();
		this.idCliente = idCliente;
		this.cnpjCpf = cnpjCpf;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getCnpjCpf() {
		return cnpjCpf;
	}

	public void setCnpjCpf(String cnpjCpf) {
		this.cnpjCpf = cnpjCpf;
	}

}