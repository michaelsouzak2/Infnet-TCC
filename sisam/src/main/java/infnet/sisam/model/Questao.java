package infnet.sisam.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "questao")
public class Questao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String pergunta;

	@Enumerated(EnumType.STRING)
	private Likert opcao;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private GrupoQuestoes grupoQuestoes;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public Likert getOpcao() {
		return opcao;
	}

	public void setOpcao(Likert opcao) {
		this.opcao = opcao;
	}

	public GrupoQuestoes getGrupoQuestoes() {
		return grupoQuestoes;
	}

	public void setGrupoQuestoes(GrupoQuestoes grupoQuestoes) {
		this.grupoQuestoes = grupoQuestoes;
	}

}
