package infnet.sisam.model;

import java.util.List;

public class TipoCurso {

	private String descricao;
	private List<Curso> cursos;
	
	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
