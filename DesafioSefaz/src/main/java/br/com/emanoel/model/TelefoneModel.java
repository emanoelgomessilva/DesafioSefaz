package br.com.emanoel.model;

public class TelefoneModel{
	
	private Integer codigo;
	private Integer ddd;
	private String numero;
	private String tipo;
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	private UsuarioModel usuarioModel;
	
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
	public UsuarioModel getUsuarioModel() {
		return usuarioModel;
	}
	public void setUsuarioModel(UsuarioModel usuarioModel) {
		this.usuarioModel = usuarioModel;
	}
	
	
}
