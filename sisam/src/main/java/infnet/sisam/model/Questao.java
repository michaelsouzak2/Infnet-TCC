package infnet.sisam.model;

public class Questao {

	private Topico topico;
	private String pergunta;
	private Likert opcao;
	
	public Likert getOpcao() {
		return opcao;
	}

	public void setOpcao(Likert opcao) {
		this.opcao = opcao;
	}

	public Topico getTopico() {
		return topico;
	}

	public void setTopico(Topico topico) {
		this.topico = topico;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

}
