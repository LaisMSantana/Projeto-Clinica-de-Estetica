package model.bo;

import model.dao.ProcedimentoDAO;
import model.vo.Procedimento;

public class ProcedimentoBO {
	private ProcedimentoDAO procedimentoDao = new ProcedimentoDAO();

	public  int salvar(Procedimento procedimento) {
		return procedimentoDao.cadastrarProcedimentoDAO(procedimento);
		// TODO Auto-generated method stub
		
	}

}
