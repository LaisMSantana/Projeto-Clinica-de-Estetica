package model.vo;

import java.util.Date;

public class Agendamento {

	private int idAgendamento;
	private Date data;
	private Procedimento procedimento;
	private Cliente cliente;
	private Funcionario funcionario;
	private String Status;

	public Agendamento() {
		super();
	}

	public Agendamento(int idAgendamento, Date data, Procedimento procedimento, Cliente cliente,
			Funcionario funcionario, String status) {
		super();
		this.idAgendamento = idAgendamento;
		this.data = data;
		this.procedimento = procedimento;
		this.cliente = cliente;
		this.funcionario = funcionario;
		Status = status;
	}


	public int getIdAgendamento() {
		return idAgendamento;
	}

	public void setIdAgendamento(int idAgendamento) {
		this.idAgendamento = idAgendamento;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Procedimento getProcedimento() {
		return procedimento;
	}

	public void setProcedimento(Procedimento procedimento) {
		this.procedimento = procedimento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	

}
