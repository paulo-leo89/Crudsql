package br.com.unipac.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "vendedor")
public class Vendedor extends IDEntity {
	
	private static final long serialVersionUID = -7390358691337193255L;


	@NotNull
	@NotEmpty(message = "você digitou o nome errado.")
	@Column(name = "nm_nome")
	private String nome;

	@Column(name = "ix_email")
	private String email;

	public Vendedor(@NotNull @NotEmpty(message = "você digitou o nome errado.") String nome, String email) {
		super();
		this.nome = nome;
		this.email = email;
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

}
