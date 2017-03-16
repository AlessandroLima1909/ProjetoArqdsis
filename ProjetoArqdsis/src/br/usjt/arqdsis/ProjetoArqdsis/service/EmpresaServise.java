package br.usjt.arqdsis.ProjetoArqdsis.service;

import br.usjt.arqdsis.ProjetoArqdsis.dao.EmpresaDAO;
import br.usjt.arqdsis.ProjetoArqdsis.model.Empresa;

public class EmpresaServise {
	EmpresaDAO empresaDAO = new EmpresaDAO();	
	
	
	public int criar(Empresa empresa) {
		return empresaDAO.criar(empresa);
	}
	
	public void atualizar(Empresa empresa){
		empresaDAO.atualizar(empresa);
	}
	
	public void excluir(int id){
		empresaDAO.excluir(id);
	}
	
	public Empresa carregar(int id){
		return empresaDAO.carregar(id);
	}


}
