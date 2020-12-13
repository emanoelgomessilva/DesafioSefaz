package br.com.emanoel.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.emanoel.model.TelefoneModel;
import br.com.emanoel.model.UsuarioModel;
import br.com.emanoel.repository.entity.TelefoneEntity;
import br.com.emanoel.repository.entity.UsuarioEntity;
import br.com.emanoel.uteis.Uteis;
 
 
public class UsuarioRepository implements Serializable {
 
	@Inject
	UsuarioEntity usuarioEntity;
	
	@Inject
	TelefoneEntity telefoneEntity;
 
	EntityManager entityManager;
 
	private static final long serialVersionUID = 1L;
 
	public UsuarioEntity ValidaUsuario(UsuarioModel usuarioModel){
 
		try {
  	
			Query query = Uteis.JpaEntityManager().createNamedQuery("UsuarioEntity.findUser");
 
			query.setParameter("usuario", usuarioModel.getNome());
			query.setParameter("senha", usuarioModel.getSenha());
 
			return (UsuarioEntity)query.getSingleResult();
 
		} catch (Exception e) {
 
			return null;
		}
 
	}
	
	/***
	 * MÉTODO RESPONSÁVEL POR SALVAR UM NOVO USUÁRIO
	 * @param pessoaModel
	 */
	public void SalvarNovoRegistro(UsuarioModel usuarioModel){
 
		entityManager =  Uteis.JpaEntityManager();
 
		usuarioEntity = new UsuarioEntity();
		usuarioEntity.setEmail(usuarioModel.getEmail());
		usuarioEntity.setUsuario(usuarioModel.getNome());
		usuarioEntity.setSenha(usuarioModel.getSenha());
		
		Set<TelefoneEntity> telefonesEntity = new HashSet<TelefoneEntity>();
		
		for(TelefoneModel telefoneModel: usuarioModel.getTelefonesModel()) {
			
			TelefoneEntity telefoneEntity = new TelefoneEntity();
			
			telefoneEntity.setDdd(telefoneModel.getDdd());
			telefoneEntity.setNumero(telefoneModel.getNumero());
			telefoneEntity.setTipo(telefoneModel.getTipo());
			telefoneEntity.setUsuarioEntity(usuarioEntity);
			
			telefonesEntity.add(telefoneEntity);
			
		}
		
		usuarioEntity.setTelefonesEntity(telefonesEntity);

 
		entityManager.persist(usuarioEntity);
 
	}
	
	/***
	 * MÉTODO PARA CONSULTAR UM USUÁRIO
	 * @return
	 */
	public List<UsuarioModel> GetUsuarios(){
 
		List<UsuarioModel> usuariosModel = new ArrayList<UsuarioModel>();
 
		entityManager =  Uteis.JpaEntityManager();
 
		Query query = entityManager.createNamedQuery("UsuarioEntity.findAll");
 
		@SuppressWarnings("unchecked")
		Collection<UsuarioEntity> usuariosEntity = (Collection<UsuarioEntity>)query.getResultList();
 
		UsuarioModel usuarioModel = null;
 
		for (UsuarioEntity usuarioEntity : usuariosEntity) {
 
			usuarioModel = new UsuarioModel();
			usuarioModel.setCodigo(usuarioEntity.getCodigo());
			usuarioModel.setEmail(usuarioEntity.getEmail());
			usuarioModel.setNome(usuarioEntity.getUsuario());
			usuarioModel.setSenha(usuarioEntity.getSenha());
 
			for(TelefoneEntity telefoneEntity: usuarioEntity.getTelefonesEntity()) {
				
				if(telefoneEntity.getTipo().equals("C") ) {
					usuarioModel.setDddCelular(Integer.toString(Integer.valueOf(telefoneEntity.getDdd())));
					usuarioModel.setTelefoneCelular(telefoneEntity.getNumero());
				}else {
					usuarioModel.setDddResidencial(Integer.toString(Integer.valueOf(telefoneEntity.getDdd())));
					usuarioModel.setTelefoneResidencial(telefoneEntity.getNumero());
				}
				
			}
 
			usuariosModel.add(usuarioModel);
		}
 
		return usuariosModel;
 
	}
	
	/***
	 * CONSULTA UM USUÁRIO CADASTRADO PELO CÓDIGO
	 * @param codigo
	 * @return
	 */
	private UsuarioEntity GetUsuario(int codigo){
 
		entityManager =  Uteis.JpaEntityManager();
 
		return entityManager.find(UsuarioEntity.class, codigo);
	}
	
	/***
	 * ALTERA UM REGISTRO CADASTRADO NO BANCO DE DADOS
	 * @param pessoaModel
	 */
	public void AlterarRegistro(UsuarioModel usuarioModel){
 
		entityManager =  Uteis.JpaEntityManager();
 
		UsuarioEntity usuarioEntity = this.GetUsuario(usuarioModel.getCodigo());
 
		usuarioEntity.setEmail(usuarioModel.getEmail());
		usuarioEntity.setUsuario(usuarioModel.getNome());
		usuarioEntity.setSenha(usuarioModel.getSenha());
		
		Set<TelefoneEntity> telefonesEntity = new HashSet<TelefoneEntity>();

		for(TelefoneEntity telefoneEntity: usuarioEntity.getTelefonesEntity()) {
			
			if(telefoneEntity.getTipo().equals("C")) {
				telefoneEntity.setDdd(Integer.valueOf(usuarioModel.getDddCelular()));
				telefoneEntity.setNumero(usuarioModel.getTelefoneCelular());
			}else {
				telefoneEntity.setDdd(Integer.valueOf(usuarioModel.getDddResidencial()));
				telefoneEntity.setNumero(usuarioModel.getTelefoneResidencial());
			}
			
			telefonesEntity.add(telefoneEntity);
			
		}
		
		usuarioEntity.setTelefonesEntity(telefonesEntity);
		
		entityManager.merge(usuarioEntity);
	}
	
	/***
	 * EXCLUI UM REGISTRO DO BANCO DE DADOS
	 * @param codigo
	 */
	public void ExcluirRegistro(int codigo){
 
		entityManager =  Uteis.JpaEntityManager();		
 
		UsuarioEntity usuarioEntity = this.GetUsuario(codigo);
 
		entityManager.remove(usuarioEntity);
	}
	
}
