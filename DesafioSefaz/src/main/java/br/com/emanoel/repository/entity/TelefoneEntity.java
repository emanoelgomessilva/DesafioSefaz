package br.com.emanoel.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name="TB_TELEFONE")
@Entity	
public class TelefoneEntity {
	
	@Id
	@GeneratedValue
	@Column(name = "ID_TELEFONE")
	private Integer codigo;
	
	@Column(name = "DDD_TELEFONE")
	private Integer ddd;
	
	@Column(name = "NUMERO_TELEFONE")
	private String numero;
	
	@Column(name = "TIPO_TELEFONE")
	private String tipo;
	
	@ManyToOne
	@JoinColumn(name = "ID_USUARIO", nullable = false)
	private UsuarioEntity usuarioEntity;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getDdd() {
		return ddd;
	}

	public void setDdd(Integer ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public UsuarioEntity getUsuarioEntity() {
		return usuarioEntity;
	}

	public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
		this.usuarioEntity = usuarioEntity;
	}
	
}
