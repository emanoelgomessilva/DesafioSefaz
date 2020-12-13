package br.com.emanoel.repository.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
 
@Table(name="tb_usuario")
@Entity

@NamedQueries({
	 
	@NamedQuery(name = "UsuarioEntity.findAll",query= "SELECT u FROM UsuarioEntity u"),
	@NamedQuery(name = "UsuarioEntity.findUser", query= "SELECT u FROM UsuarioEntity u WHERE u.usuario = :usuario AND u.senha = :senha")
 
})


public class UsuarioEntity implements Serializable {
 
	private static final long serialVersionUID = 1L;
 
	@Id
	@GeneratedValue
	@Column(name="ID_USUARIO")
	private Integer codigo;
 
	@Column(name="NOME_USUARIO")
	private String usuario;
 
	@Column(name="SENHA_USUARIO")
	private String senha;
	
	@Column(name="EMAIL_USUARIO")
	private String email;
	
	@OneToMany(mappedBy = "usuarioEntity", cascade = CascadeType.ALL)
	private Set<TelefoneEntity> telefonesEntity;
	
 
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Set<TelefoneEntity> getTelefonesEntity() {
		return telefonesEntity;
	}
	public void setTelefonesEntity(Set<TelefoneEntity> telefones) {
		this.telefonesEntity = telefones;
	}
 
}