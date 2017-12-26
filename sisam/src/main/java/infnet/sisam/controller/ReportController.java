package infnet.sisam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import infnet.sisam.model.Avaliacao;
import infnet.sisam.service.AvaliacaoService;
import infnet.sisam.service.ReportService;

@Controller
@RequestMapping("/report")
public class ReportController {

	@Autowired
	private ReportService reportService;
	@Autowired
	private AvaliacaoService avaliacaoService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView novo() {
		ModelAndView modelAndView = new ModelAndView("/report/excel");
		List<Avaliacao> avaliacoes = avaliacaoService.listar();
		modelAndView.addObject("avaliacoes", avaliacoes);
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public HttpEntity<byte[]> downloadExcel(Avaliacao avaliacao) {
		String fileName = "Relatorio_da_avaliação_id:" + avaliacao.getId() + ".xlsx";
		byte[] arquivo = reportService.createExcel(avaliacao);
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Content-Disposition", "attachment;filename=\""+fileName+"\"");
	    HttpEntity<byte[]> entity = new HttpEntity<byte[]>(arquivo,httpHeaders);

	   return entity;
	}
	
}
