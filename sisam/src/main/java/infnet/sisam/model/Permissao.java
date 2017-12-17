package infnet.sisam.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import infnet.sisam.enumeration.PermissaoEnum;

@Entity
@Table(name="permissao")
public class Permissao implements GrantedAuthority {

	private static final long serialVersionUID = -405335995759771078L;

	@Id
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	private PermissaoEnum nome;

	public Permissao() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PermissaoEnum getNome() {
		return nome;
	}

	public void setNome(PermissaoEnum nome) {
		this.nome = nome;
	}

	@Override
	public String getAuthority() {
		return this.nome.name();
	}

	@Override
	public String toString() {
		return this.nome.getDescricao();
	}

}
