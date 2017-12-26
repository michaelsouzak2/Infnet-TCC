package infnet.sisam.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import infnet.sisam.dao.RespostaQuestaoDao;
import infnet.sisam.model.Avaliacao;
import infnet.sisam.model.Likert;
import infnet.sisam.model.RespostaQuestao;
import infnet.sisam.schedule.EmailSchedule;

@Service
@Transactional
public class ReportService {
	
	@Autowired
	private RespostaQuestaoDao respotaQuestaoDao;
	
	private static final Logger LOGGER = Logger.getLogger(ReportService.class);
	
	public byte[] createExcel(Avaliacao avaliacao) {
		
		@SuppressWarnings("resource")
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("Planilha avaliação");
		
		List<RespostaQuestao> respostas = respotaQuestaoDao.findByAvaliacao(avaliacao);
		Avaliacao av = respostas.get(0).getAvaliacao();
		
		for (int rownum = 0; rownum < respostas.size(); rownum++) {
			
			if(rownum == 0) {
				Row row = sheet.createRow(rownum);
				int cellnum = 0;
				
				Cell cellAvalicao = row.createCell(cellnum++);
				cellAvalicao.setCellValue("Avaliação: " + av.getId());
				
				Cell cellModulo = row.createCell(cellnum++);
				cellModulo.setCellValue("Módulo: " + av.getTurmas().get(0).getModulo().getNome());
				
				Cell cellTurma = row.createCell(cellnum++);
				cellTurma.setCellValue("Turma: " + av.getTurmas().get(0).getDescricao());
				
				Cell cellProfessor = row.createCell(cellnum++);
				cellProfessor.setCellValue("Professor: " + av.getTurmas().get(0).getProfessor().getNome());
			}
			else if(rownum == 1) {
				Row row = sheet.createRow(rownum);
				int cellnum = 0;
				
				Cell cellQuestao = row.createCell(cellnum++);
				cellQuestao.setCellValue("Questão");
				
				Cell cellConTot = row.createCell(cellnum++);
				cellConTot.setCellValue(Likert.CONCORDO_TOTALMENTE.getOpcao());
				
				Cell cellCon = row.createCell(cellnum++);
				cellCon.setCellValue(Likert.CONCORDO.getOpcao());
				
				Cell cellNConcDisc = row.createCell(cellnum++);
				cellNConcDisc.setCellValue(Likert.NAO_CONCORDO_NEM_DISCORDO.getOpcao());
				
				Cell cellDis = row.createCell(cellnum++);
				cellDis.setCellValue(Likert.DISCORDO.getOpcao());
				
				Cell cellDisTot = row.createCell(cellnum++);
				cellDisTot.setCellValue(Likert.DISCORDO_TOTALMENTE.getOpcao());
				
				Cell cellNSei = row.createCell(cellnum++);
				cellNSei.setCellValue(Likert.NAO_SEI_AVALIAR.getOpcao());
			}
			else {
				
				int rowbody = rownum - 2;
				
				for (int i = 2; i < sheet.getLastRowNum() + 2; ) {
					if(sheet.getRow(i) != null && 
							sheet.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase(respostas.get(rowbody).getQuestao().getPergunta())) {
						
						switch (respostas.get(rowbody).getResposta()) {
						case CONCORDO_TOTALMENTE:
							if(sheet.getRow(i).getCell(1).getStringCellValue() == null) {
								sheet.getRow(i).getCell(1).setCellValue("1");
							}else {
								sheet.getRow(i).getCell(1).setCellValue(
										String.valueOf(Integer.valueOf(sheet.getRow(i).getCell(1).getStringCellValue()) + 1));
							}
							break;
						case CONCORDO:
							if(sheet.getRow(i).getCell(2).getStringCellValue() == null) {
								sheet.getRow(i).getCell(2).setCellValue("1");
							}else {
								sheet.getRow(i).getCell(2).setCellValue(
										String.valueOf(Integer.valueOf(sheet.getRow(i).getCell(2).getStringCellValue()) + 1));
							}
							break;
						case NAO_CONCORDO_NEM_DISCORDO:
							if(sheet.getRow(i).getCell(3).getStringCellValue() == null) {
								sheet.getRow(i).getCell(3).setCellValue("1");
							}else {
								sheet.getRow(i).getCell(3).setCellValue(
										String.valueOf(Integer.valueOf(sheet.getRow(i).getCell(3).getStringCellValue()) + 1));
							}
							break;
						case DISCORDO:
							if(sheet.getRow(i).getCell(4).getStringCellValue() == null) {
								sheet.getRow(i).getCell(4).setCellValue("1");
							}else {
								sheet.getRow(i).getCell(4).setCellValue(
										String.valueOf(Integer.valueOf(sheet.getRow(i).getCell(4).getStringCellValue()) + 1));
							}
							break;
						case DISCORDO_TOTALMENTE:
							if(sheet.getRow(i).getCell(5).getStringCellValue() == null) {
								sheet.getRow(i).getCell(5).setCellValue("1");
							}else {
								sheet.getRow(i).getCell(5).setCellValue(
										String.valueOf(Integer.valueOf(sheet.getRow(i).getCell(5).getStringCellValue()) + 1));
							}
							break;
						case NAO_SEI_AVALIAR:
							if(sheet.getRow(i).getCell(6).getStringCellValue() == null) {
								sheet.getRow(i).getCell(6).setCellValue("1");
							}else {
								sheet.getRow(i).getCell(6).setCellValue(
										String.valueOf(Integer.valueOf(sheet.getRow(6).getCell(1).getStringCellValue()) + 1));
							}
							break;

						default:
							break;
						}
							
					}
					i++;
					if(i == sheet.getLastRowNum() + 2){
						Row row = sheet.createRow(rowbody);
						int cellnum = 0;
						Cell cellPergunta = row.createCell(cellnum++);
						cellPergunta.setCellValue(respostas.get(rowbody).getQuestao().getPergunta());
					}
				}
				
			}
			
		}
		
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
				workbook.write(bos);
				return bos.toByteArray();
			} catch (IOException e) {
				e.printStackTrace();
				LOGGER.error(e.getMessage());
				return null;
			}
	}
	
	
	
}
