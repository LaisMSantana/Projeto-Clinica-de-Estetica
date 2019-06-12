package model.vo;

public class Cliente extends Pessoa {

	private int idCliente;

	public Cliente() {
		super();
	}

	public Cliente(String nome, String cpf, String endereco, String bairro, String cep, String municipio, String estado,
			String telefone, String celular, String email, String dataDeNascimento) {
		super(nome, cpf, endereco, bairro, cep, municipio, estado, telefone, celular, email, dataDeNascimento);
	}

	public Cliente(int idCliente) {
		super();
		this.idCliente = idCliente;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

}