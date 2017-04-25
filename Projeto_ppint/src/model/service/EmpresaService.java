package model.service;

import model.dao.EmpresaDAO;
import model.javabean.Empresa;

public class EmpresaService 
{
	EmpresaDAO dao;
	
	public EmpresaService()
	{
		dao = new EmpresaDAO();
	}
	
	public void criar(Empresa to)
	{
		dao.cadastrarEmpresa(to);
	}
	public void atualizar(Empresa to)
	{
		dao.alterarEmpresa(to);
	}
	public void excluir(Empresa to)
	{
		dao.excluirEmpresa(to);
	}
	public void carregar(Empresa to)
	{
		dao.consultarEmpresa(to);
	}
}
