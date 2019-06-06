package bo;

import dao.ProcedimentoDAO;
import model.vo.Procedimento;

public class CadastroProcedimentoBO {
	private ProcedimentoDAO procedimentoDao = new ProcedimentoDAO();

	public  String salvar(Procedimento procedimento) {
		return procedimentoDao.cadastrarProcedimentoDao(procedimento)
		// TODO Auto-generated method stub
		
	}

}
