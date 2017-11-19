package infnet.sisam.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

import infnet.sisam.enumeration.PerfilEnum;

@Entity
public class Perfil implements GrantedAuthority {

	private static final long serialVersionUID = -5933439712613771042L;
	
	@Id
	@Enumerated(EnumType.STRING)
	private PerfilEnum nome;

	public Perfil() {
	}

	public PerfilEnum getNome() {
		return nome;
	}

	public void setNome(PerfilEnum nome) {
		this.nome = nome;
	}

	@Override
	public String getAuthority() {
		return this.nome.name();
	}

}
