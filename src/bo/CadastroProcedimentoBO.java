package bo;

import dao.ProcedimentoDAO;
import model.vo.Procedimento;

public class CadastroProcedimentoBO {
	private ProcedimentoDAO procedimentoDao = new ProcedimentoDAO();

	public  int salvar(Procedimento procedimento) {
		return procedimentoDao.cadastrarProcedimentoDAO(procedimento);
		// TODO Auto-generated method stub
		
	}

}
