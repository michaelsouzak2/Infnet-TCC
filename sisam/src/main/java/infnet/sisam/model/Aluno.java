package infnet.sisam.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQuery(name = "Aluno.verificaAcessoAvaliacao", query = "SELECT a FROM Aluno a "
		+ "JOIN FETCH a.turma t JOIN FETCH t.avaliacao av " + "WHERE  a.id=:idAluno")
@Entity
@Table(name = "aluno")
public class Aluno {
	@Id
	private Integer id;
	private Integer matricula;
	private String nome;
	private String email;
	private String sexo;

	@ManyToOne(fetch = FetchType.EAGER)
	private Turma turma;

	// @OneToMany
	// private List<Avaliacao> avaliacoes;
	
	public Aluno() {
	}
	
	public Aluno(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

}
