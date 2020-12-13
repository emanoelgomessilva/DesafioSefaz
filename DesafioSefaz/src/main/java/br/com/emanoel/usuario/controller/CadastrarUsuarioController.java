package br.com.emanoel.usuario.controller;


import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.emanoel.model.TelefoneModel;
import br.com.emanoel.model.UsuarioModel;

import br.com.emanoel.repository.UsuarioRepository;
import br.com.emanoel.uteis.Uteis;

@Named(value="cadastrarUsuarioController")
@RequestScoped
public class CadastrarUsuarioController {

	@Inject
	UsuarioModel usuarioModel;

	@Inject
	UsuarioController usuarioController;

	@Inject
	UsuarioRepository usuarioRepository;

	public UsuarioModel getUsuarioModel() {
		return usuarioModel;
	}

	public void setPessoaModel(UsuarioModel usuarioModel) {
		this.usuarioModel = usuarioModel;
	}
	
	public void IrParaPaginaInicial() throws IOException 
	{
		FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
	}

	/**
	 *SALVA UM NOVO REGISTRO
	 */
	public void SalvarNovoUsuario(){
		
		Set<TelefoneModel> telefonesModel = new HashSet<TelefoneModel>();
		
		TelefoneModel telefoneResidencial = new TelefoneModel();
		telefoneResidencial.setDdd(Integer.valueOf(usuarioModel.getDddResidencial()));
		telefoneResidencial.setNumero(usuarioModel.getTelefoneResidencial());
		telefoneResidencial.setTipo("R");
		
		telefonesModel.add(telefoneResidencial);
		
		TelefoneModel telefoneCelular = new TelefoneModel();
		telefoneCelular.setDdd(Integer.valueOf(usuarioModel.getDddCelular()));
		telefoneCelular.setNumero(usuarioModel.getTelefoneCelular());
		telefoneCelular.setTipo("C");
		
		telefonesModel.add(telefoneCelular);
		
		usuarioModel.setTelefonesModel(telefonesModel);

		usuarioRepository.SalvarNovoRegistro(this.usuarioModel);

		this.usuarioModel = null;

		Uteis.MensagemInfo("Registro cadastrado com sucesso");

	}

}