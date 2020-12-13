package br.com.emanoel.model;

import java.io.Serializable;
import java.util.Set;

public class UsuarioModel implements Serializable {
 
	private static final long serialVersionUID = 1L;
 
	private Integer codigo;
	private String nome;
	private String senha;
	private String email;
	private String telefoneResidencial;
	private String telefoneCelular;
	private String dddResidencial;
	private String dddCelular;
	
	public String getTelefoneResidencial() {
		return telefoneResidencial;
	}
	public void setTelefoneResidencial(String telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}
	public String getTelefoneCelular() {
		return telefoneCelular;
	}
	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}
	public String getDddResidencial() {
		return dddResidencial;
	}
	public void setDddResidencial(String dddResidencial) {
		this.dddResidencial = dddResidencial;
	}
	public String getDddCelular() {
		return dddCelular;
	}
	public void setDddCelular(String dddCelular) {
		this.dddCelular = dddCelular;
	}
	private Set<TelefoneModel> telefonesModel;
	
	public Set<TelefoneModel> getTelefonesModel() {
		return telefonesModel;
	}
	public void setTelefonesModel(Set<TelefoneModel> telefonesModel) {
		this.telefonesModel = telefonesModel;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
 
	
 
}
