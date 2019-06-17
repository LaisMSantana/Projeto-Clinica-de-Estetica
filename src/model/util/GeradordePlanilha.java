package model.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import model.dao.AgendamentoDAO;
import model.vo.Agendamento;

public class GeradordePlanilha {
	public String extensao;
	public XSSFWorkbook planilha;
	public XSSFWorkbook Workbook;

	public String gerarPlanilha(String caminhoArquivo, List<Agendamento> agendamentos) {
		XSSFWorkbook workbook = null;
		OutputStream outputStream = null;
		try {
			workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("Agendamentos");

			XSSFRow linhaCabecalho = sheet.createRow(0);
			linhaCabecalho.createCell(0).setCellValue("Cliente");
			linhaCabecalho.createCell(1).setCellValue("Procedimento");
			linhaCabecalho.createCell(2).setCellValue("Data");
			linhaCabecalho.createCell(3).setCellValue("Horário");
			linhaCabecalho.createCell(4).setCellValue("Sala");

			DateFormat data = new SimpleDateFormat("dd/MM/yyyy");
			DateFormat hora = new SimpleDateFormat("HH:mm");

			int linha = 1;
			for (Agendamento agendamento : agendamentos) {
				XSSFRow row = sheet.createRow(linha);
				row.createCell(0).setCellValue(agendamento.getCliente().getNome());
				row.createCell(1).setCellValue(agendamento.getProcedimento().getNome());
				row.createCell(2).setCellValue(data.format(agendamento.getData()));
				row.createCell(3).setCellValue(hora.format(agendamento.getData()));
				row.createCell(4).setCellValue(agendamento.getProcedimento().getSala());
				linha++;
			}

			outputStream = new FileOutputStream(caminhoArquivo);
			workbook.write(outputStream);
			return "Planilha gerada com sucesso!";
		} catch (FileNotFoundException e) {
			return "Erro ao tentar salvar planilha em: " + caminhoArquivo;
		} catch (IOException e) {
			return "Erro ao tentar salvar planilha em: " + caminhoArquivo;
		} finally {
			if (workbook != null) {
				try {
					workbook.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
		List<Agendamento> agendamentos = agendamentoDAO.listarTodos();
		new GeradordePlanilha().gerarPlanilha("/home/jhully/teste_agendamentos.xlsx", agendamentos);
	}
}