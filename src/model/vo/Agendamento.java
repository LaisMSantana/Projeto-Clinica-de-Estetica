package model.vo;

import java.util.Date;

public class Agendamento {

	private int idAgendamento;
	private Date data;
	private Procedimento procedimento;
	private Cliente cliente;
	private Funcionario funcionario;

	public Agendamento() {
		super();
	}

	public Agendamento(int idAgendamento, Date data, Procedimento procedimento, Funcionario funcionario,
			Cliente cliente) {
		super();
		this.idAgendamento = idAgendamento;
		this.data = data;
		this.procedimento = procedimento;
		this.funcionario = funcionario;
		this.cliente = cliente;
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

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
