package br.com.emanoel.usuario.controller;

import java.io.Serializable;
import java.util.List;
 
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
 
import br.com.emanoel.model.UsuarioModel;
import br.com.emanoel.repository.UsuarioRepository;
 
@Named(value="consultarUsuariosController")
@ViewScoped
public class ConsultarUsuariosController implements Serializable {
 
	private static final long serialVersionUID = 1L;
 
	@Inject transient
	private UsuarioModel usuarioModel;
 
	@Produces 
	private List<UsuarioModel> usuarios;
 
	@Inject transient
	private UsuarioRepository usuarioRepository;
 
	public List<UsuarioModel> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<UsuarioModel> usuarios) {
		this.usuarios = usuarios;
	}		
	public UsuarioModel getUsuarioModel() {
		return usuarioModel;
	}
	public void setUsuarioModel(UsuarioModel usuarioModel) {
		this.usuarioModel = usuarioModel;
	}
 
	/***
	 * CARREGA A LISTA DE USUÁRIOS NA INICIALIZAÇÃO 
	 */
	@PostConstruct
	public void init(){
 
		this.usuarios = usuarioRepository.GetUsuarios();
	}
 
	
	/***
	 * CARREGA INFORMAÇÕES DE UM USUÁRIO PARA SER EDITADO
	 * @param usuarioModel
	 */
	public void Editar(UsuarioModel usuarioModel){
 
		this.usuarioModel = usuarioModel;
 
	}
 
	/***
	 * ATUALIZA O REGISTRO QUE FOI ALTERADO
	 */
	public void AlterarRegistro(){
 
		this.usuarioRepository.AlterarRegistro(this.usuarioModel);	
 
		this.init();
	}
	
	/***
	 * EXCLUINDO UM REGISTRO
	 * @param usuarioModel
	 */
	public void ExcluirUsuario(UsuarioModel usuarioModel){
 
		this.usuarioRepository.ExcluirRegistro(usuarioModel.getCodigo());
 
		this.usuarios.remove(usuarioModel);
 
	}
 
}
