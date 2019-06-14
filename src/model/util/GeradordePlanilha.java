package model.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import model.vo.Agendamento;

public class GeradordePlanilha {
	public String extensao;
	public XSSFWorkbook planilha;
	public  XSSFWorkbook Workbook;
	/**
	 * Gera uma planilha Excel (formato .xlsx) a partir de uma lista de produtos
	 * 
	 * @param caminhoArquivo onde a planilha será salva
	 * @param produtos       a lista de produtos
	 * 
	 * @return uma mensagem informando ao usuário o que ocorreu.
	 */

	public String gerarPlanilhaAgendamentos(String caminhoArquivo,List<Agendamento>agendamentos) {
		return caminhoArquivo;
		
		
		/// Criar a planilha (Workbook)
			//	 XSSFWorkbook planilha = new XSSFWorkbook();	
		
				/// 	 Criar uma aba (Sheet)
			//	XSSFSheet aba = (XSSFSheet) planilha.createSheet("Agendamentos");
				
		//		int linhaAtual = 0;

				/// 	 Criar o cabeçalho (header)
		//		String[] nomesColunas = { "Cliente", "Procedimento", "Data ", "Horario","Sala" };
		//	criarCabecalho(nomesColunas, aba, linhaAtual);
			/// 	 Salvar o arquivo gerado no disco
			//	return salvarNoDisco((org.apache.poi.xssf.usermodel.XSSFWorkbook) planilha, caminhoArquivo, ".xlsx");
	}
				
				
	
		


				private void criarLinhasAgendamentos(List<Agendamento> agendamentos2, XSSFSheet aba, int posicaoLinhaAtual) {
				//			for (Agendamento a : agendamentos2) {
						// criar uma nova linha na planilha
					//					XSSFRow linhaAtual1 = aba.createRow(posicaoLinhaAtual);

						// Preencher as células com os atributos do Produto p
					//					linhaAtual1.createCell(0).setCellValue(a.getIdAgendamento());
					//		linhaAtual1.createCell(1).setCellValue(new Date(a.getData()));

			//			posicaoLinhaAtual++;
					}

				

				String criarCabecalho(String[] nomesColunas, XSSFSheet aba, int posicaoLinhaAtual) {
					Row linhaAtual1 = aba.createRow(posicaoLinhaAtual);

					posicaoLinhaAtual++;
					// Para mudar o estilo:
				 https://stackoverflow.com/questions/43467253/setting-style-in-apache-poi
			//	for (int i = 0; i < nomesColunas.length; i++) {
				//			Cell novaCelula = linhaAtual1.createCell(i);
			//		novaCelula.setCellValue(nomesColunas[i]);
					}
				

				private String salvarNoDisco(XSSFWorkbook planilha, String caminhoArquivo, String extensao) {
					String mensagem = "";
					FileOutputStream saida = null;

					String extensao1 = null;
					try {
						String caminhoArquivoNovo = null;
						saida = new FileOutputStream(new File(caminhoArquivoNovo + extensao1));
					//	planilha.write(saida);
						mensagem = "Planilha gerada com sucesso!";
					} catch (FileNotFoundException e) {
						String caminhoArquivoNovo;
						mensagem = "Erro ao tentar salvar planilha em: " + caminhoArquivo + extensao1;
						System.out.println("Causa: " + e.getMessage());
					} catch (IOException e1) {
						String caminhoArquivoNovo;
						mensagem = "Erro ao tentar salvar planilha em: " + caminhoArquivo + extensao1;
						Throwable e = null;
						System.out.println("Causa: " + e.getMessage());
					} finally {
						if (saida != null) {
							try {
								saida.close();
								FileOutputStream planilha1 = null;
								planilha1.close();
							} catch (IOException e) {
								String caminhoArquivoNovo;
								
								mensagem = "Erro ao tentar salvar planilha em: " + caminhoArquivo + extensao1;
								System.out.println("Causa: " + e.getMessage());
							}
						}
					}
				
					return mensagem;
				

				
				
	

	
	
	
	
	
	
	
	
}
}