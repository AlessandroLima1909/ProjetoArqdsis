package br.usjt.arqdsis.ProjetoArqdsis.service;

import br.usjt.arqdsis.ProjetoArqdsis.dao.UsuarioDAO;
import br.usjt.arqdsis.ProjetoArqdsis.model.Usuario;

public class UsuarioService {
UsuarioDAO usuarioDAO = new UsuarioDAO();	
	
	
	public int criar(Usuario usuario) {
		return usuarioDAO.criar(usuario);
	}
	
	public void atualizar(Usuario usuario){
		usuarioDAO.atualizar(usuario);
	}
	
	public void excluir(int id){
		usuarioDAO.excluir(id);
	}
	
	public Usuario carregar(int id){
		return usuarioDAO.carregar(id);
	}

}
