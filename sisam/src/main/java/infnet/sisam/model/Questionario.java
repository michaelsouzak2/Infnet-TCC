package infnet.sisam.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="questionario")
public class Questionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String sigla;
	private String descricao;
	@ManyToMany(fetch = FetchType.EAGER)
	private List<GrupoQuestoes> gruposQuestoes;

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

	public List<GrupoQuestoes> getGruposQuestoes() {
		return gruposQuestoes;
	}

	public void setGruposQuestoes(List<GrupoQuestoes> gruposQuestoes) {
		this.gruposQuestoes = gruposQuestoes;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
}
