package model.vo;

public class Cliente extends Pessoa {

	private int idCliente;
	private String cpf;

	public Cliente() {
		super();
	}

	public Cliente(int idCliente, String cpf) {
		super();
		this.idCliente = idCliente;
		this.cpf = cpf;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	

}