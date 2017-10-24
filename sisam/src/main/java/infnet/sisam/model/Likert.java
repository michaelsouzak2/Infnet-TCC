package infnet.sisam.model;

public enum Likert {

	CONCORDO_TOTALMENTE("Concordo totalmente"),
	CONCORDO("Concordo"),
	NAO_CONCORDO_NEM_DISCORDO("Não concordo nem discordo"),
	DISCORDO("Discordo"),
	DISCORDO_TOTALMENTE("Discordo totalmente"),
	NAO_SEI_AVALIAR("Não sei avaliar");
	
	private String opcao;
	
	Likert(String opcao) {
		this.opcao = opcao;
	}
	
	public String getOpcao() {
		return opcao;
	}

}
