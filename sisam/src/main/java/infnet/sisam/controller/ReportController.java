package infnet.sisam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/report")
public class ReportController {

//	private int numlinha = 0;
//	// private Row row;
//	private HSSFRow row;
//
//	private String TipoQuestao;
//	private String TopicoCorrente;
//	private String TurmaCorrente;
//	private String TurmaVigente;
//
//	public void exportaExcel(Avaliacao avaliacao, String nomeArquivo, AvaliacaoTurmaAlunoService atas)
//			throws Exception {
//
//		HSSFWorkbook workbook = new HSSFWorkbook();
//		HSSFSheet sheet = workbook.createSheet("Aba Avaliação");
//
//		// Definindo alguns padroes de layout
//		sheet.setDefaultColumnWidth(42);
//		sheet.setDefaultRowHeight((short)400);
//
//		CellStyle headerStyle = workbook.createCellStyle();
//		headerStyle.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
//	
//		FileOutputStream fos = null;
//		System.out.println("ID da avaliação: " + avaliacao.getId());
//		try {
//			fos = new FileOutputStream(new File(nomeArquivo));
//			List<AvaliacaoTurmaAluno> avaliacoes = atas.obterPorAvaliacao(avaliacao);
//			for (AvaliacaoTurmaAluno avaliacaoTurmaAluno : avaliacoes) {
//				List<Resposta> respostas = avaliacaoTurmaAluno.getResposta();
//
//				TurmaCorrente = avaliacaoTurmaAluno.getTurma();
//				if (!TurmaCorrente.equals(TurmaVigente)) {
//					TurmaVigente = avaliacaoTurmaAluno.getTurma();
//
//					int i = 0;
//					row = sheet.createRow(numlinha++);
//					row.createCell(0).setCellValue("Avaliação ");
//					row.createCell(1).setCellValue(avaliacaoTurmaAluno.getAvaliacao().getCodigo());
//
//					row = sheet.createRow(numlinha++);
//					row.createCell(0).setCellValue("Turma ");
//					row.createCell(1).setCellValue(avaliacaoTurmaAluno.getTurma());
//					i++;
//					row = sheet.createRow(numlinha++);
//					row.createCell(0).setCellValue("Modulo ");
//					row.createCell(1).setCellValue(avaliacaoTurmaAluno.getModulo());
//
//					row = sheet.createRow(numlinha++);
//					row.createCell(0).setCellValue("Professor ");
//					row.createCell(1).setCellValue(avaliacaoTurmaAluno.getProfessor());
//
//					row = sheet.createRow(numlinha++);
//					row.createCell(0).setCellValue("Questionario ");
//					row.createCell(2).setCellValue("Concordo totalmente");
//					row.createCell(3).setCellValue("Concordo");
//					row.createCell(4).setCellValue("Não concordo nem discordo");
//					row.createCell(5).setCellValue("Discordo");
//					row.createCell(6).setCellValue("Discordo totalmente");
//					row.createCell(7).setCellValue("Não sei avaliar");
//
//					i = numlinha;
//					for (Resposta resp : respostas) {
//						row = sheet.createRow(i);
//						TopicoCorrente = resp.getTextoTopico();
//						if (!TopicoCorrente.equals(TipoQuestao)) {
//							TipoQuestao = resp.getTextoTopico();
//							row.createCell(0).setCellValue(resp.getTextoTopico());
//						}
//						try {
//
//							row.createCell(1).setCellValue(resp.getTextoQuestao());
//
//							System.out.println("##########" + atas.contarTotalResposta(avaliacaoTurmaAluno.getTurma(),
//									resp.getTextoTopico(), resp.getResposta(), avaliacao));
//							sheet.setColumnWidth(1, 24000);
//							row.createCell(1).setCellValue(resp.getTextoTopico());
//							for(int value = 0; value < 6; value++){
//							row.createCell(7 - value)
//									.setCellValue(atas.contarTotalResposta(avaliacaoTurmaAluno.getTurma(),
//											resp.getTextoQuestao(), Integer.toString(value), avaliacao));
//							}
//						} catch (Exception e) {
//							System.out.println(e.getMessage());
//						}
//						i++;
//
//					} // fim do for
//					numlinha = ++i;
//				}
//			}
//			workbook.write(fos);
//
//			workbook.close();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new Exception("Erro ao exportar arquivo");
//		} finally {
//			try {
//				fos.flush();
//				fos.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//	} // fim do metodo exp
	
}
