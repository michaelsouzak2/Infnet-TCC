package infnet.sisam.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

@NamedQuery(name = "AlunoAvaliacao.buscaAlunoAvaliacao", query = "SELECT aa FROM AlunoAvaliacao aa "
		+ "WHERE  aa.avaliacao.id=:idAvaliacao AND aa.aluno.id=:idAluno")
@Entity
@Table(name = "aluno_avaliacao")
public class AlunoAvaliacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	private Avaliacao avaliacao;

	@ManyToOne
	private Aluno aluno;

	@Column(name = "avaliacao_respondida")
	private Boolean avaliacaoRespondida;

	@Transient
	private List<Questao> questoesRespondidas;

	public AlunoAvaliacao() {
	}

	public AlunoAvaliacao(Aluno aluno, Avaliacao avaliacao) {
		this.aluno = aluno;
		this.avaliacao = avaliacao;
	}

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

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Boolean getAvaliacaoRespondida() {
		return avaliacaoRespondida;
	}

	public void setAvaliacaoRespondida(Boolean avaliacao_respondida) {
		this.avaliacaoRespondida = avaliacao_respondida;
	}

	public List<Questao> getQuestoesRespondidas() {
		return questoesRespondidas;
	}

	public void setQuestoesRespondidas(List<Questao> questoesRespondidas) {
		this.questoesRespondidas = questoesRespondidas;
	}

}
