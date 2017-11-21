package infnet.sisam.enumeration;

public enum PermissaoEnum {

	ROLE_ADMINISTRADOR("ADMINISTRADOR"), ROLE_SECRETARIA("SECRETARIA");

	private String descricao;

	private PermissaoEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
