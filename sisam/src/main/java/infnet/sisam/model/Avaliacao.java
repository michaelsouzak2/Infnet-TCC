package infnet.sisam.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Avaliacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@JoinColumn(unique = true)
	@OneToMany(fetch = FetchType.EAGER)
	private List<Turma> turmas;

	@ManyToOne(fetch = FetchType.EAGER)
	private Questionario questionario;

	@Lob
	private String objetivo;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat
	private Calendar dataInicio;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat
	private Calendar dataFim;

//	@OneToOne
//	private Convite convite;

	@ManyToOne(fetch = FetchType.EAGER)
	private Usuario administrador;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

//	public Convite getConvite() {
//		return convite;
//	}
//
//	public void setConvite(Convite convite) {
//		this.convite = convite;
//	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turma) {
		this.turmas = turma;
	}

	public Questionario getQuestionario() {
		return questionario;
	}

	public void setQuestionario(Questionario questionario) {
		this.questionario = questionario;
	}

	public Usuario getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Usuario administrador) {
		this.administrador = administrador;
	}

}
