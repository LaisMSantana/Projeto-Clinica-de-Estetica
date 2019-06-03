package model.vo;

public class Agendamento {

	private int idAgendamento;
	private String data;
	private Procedimento procedimento;
	private Funcionario funcionario;
	private Cliente cliente;

	public Agendamento() {
		super();
	}

	public Agendamento(int idAgendamento, String data, Procedimento procedimento, Funcionario funcionario,
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

	public String getData() {
		return data;
	}

	public void setData(String data) {
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
