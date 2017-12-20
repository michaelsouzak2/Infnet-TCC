package infnet.sisam.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

//					"WHERE av.dataInicio = CURRENT_DATE")

@NamedQuery(name = "Avaliacao.buscaAvaliacaoPendente", 
			query = "SELECT av FROM Avaliacao av " + 
					"JOIN FETCH av.questionario q " + 
					"JOIN FETCH av.turmas t " + 
					"LEFT JOIN t.alunos a " +
					"WHERE av.dataInicio <= :dataHoje AND (av.dataFim IS NULL OR av.dataFim >= :dataHoje)")
@Entity
@Table(name = "avaliacao")
public class Avaliacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToMany(mappedBy = "avaliacao")
	@JsonIgnore
	private List<Turma> turmas;

	@ManyToOne
	private Questionario questionario;

	@Lob
	private String objetivo;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat
	@Column(name = "data_inicio")
	private Calendar dataInicio;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat
	@Column(name = "data_fim")
	private Calendar dataFim;

	@OneToOne(cascade = CascadeType.ALL)
	private Convite convite;

	@ManyToOne(fetch = FetchType.EAGER)
	private Usuario administrador;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public Questionario getQuestionario() {
		return questionario;
	}

	public void setQuestionario(Questionario questionario) {
		this.questionario = questionario;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public Calendar getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Calendar getDataFim() {
		return dataFim;
	}

	public void setDataFim(Calendar dataFim) {
		this.dataFim = dataFim;
	}

	public Convite getConvite() {
		return convite;
	}

	public void setConvite(Convite convite) {
		this.convite = convite;
	}

	public Usuario getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Usuario administrador) {
		this.administrador = administrador;
	}

}
