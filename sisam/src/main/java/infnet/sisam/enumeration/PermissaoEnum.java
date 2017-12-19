package infnet.sisam.enumeration;

public enum PermissaoEnum {

	ROLE_ADMINISTRADOR(1, "ADMINISTRADOR"), ROLE_SECRETARIA(2, "SECRETARIA"), ROLE_ALUNO(3, "ALUNO");

	private Integer id;
	private String descricao;

	private PermissaoEnum(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
