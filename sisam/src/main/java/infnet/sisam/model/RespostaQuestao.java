package infnet.sisam.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "resposta_questao")
public class RespostaQuestao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne(fetch = FetchType.EAGER)
//	@OneToOne
	private Avaliacao avaliacao;
	
	@OneToOne(fetch = FetchType.EAGER)
//	@OneToOne
	private Questao questao;
	
	@OneToOne(fetch = FetchType.EAGER)
//	@OneToOne
	private Aluno aluno;
	
	@Enumerated(EnumType.STRING)
	private Likert resposta;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}

	public Questao getQuestao() {
		return questao;
	}

	public void setQuestao(Questao questao) {
		this.questao = questao;
	}

	public Likert getResposta() {
		return resposta;
	}

	public void setResposta(Likert resposta) {
		this.resposta = resposta;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

}
