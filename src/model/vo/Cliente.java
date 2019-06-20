package model.vo;

public class Cliente extends Pessoa {

	private int idCliente;

	public Cliente() {
		super();
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