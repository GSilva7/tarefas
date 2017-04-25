package test;

import static org.junit.Assert.assertEquals;

import java.sql.Time;

import org.junit.Before;
import org.junit.Test;

import model.dao.EmpresaDAO;
import model.javabean.Empresa;

public class EmpresaTest 
{
	Empresa empresa, copia;
	EmpresaDAO dao;
	static int cnpj = 0;
	
	@SuppressWarnings("deprecation")
	@Before
	public void setUp() throws Exception
	{
		System.out.println("setup");
		empresa = new Empresa(cnpj, "Milho", new Time(00, 00, 00), new Time(23, 59, 59));
		copia = new Empresa(cnpj, "Milho", new Time(00, 00, 00), new Time(23, 59, 59));
		System.out.println(empresa);
		System.out.println(copia);
		System.out.println(cnpj);
	}

	@Test
	public void test00Carregar() 
	{
		System.out.println("carregar");
		
		@SuppressWarnings("deprecation")
		Empresa fixture = new Empresa(1, "Arroz Branco", new Time(00, 00, 00), new Time(23, 59, 59));
		Empresa novo = new Empresa(1, null, null, null);
		dao.consultarEmpresa(novo);
		assertEquals("Testa Inclusao", novo, fixture);		
	}
	
	@Test
	public void test01Criar()
	{
		System.out.println("criar");
		dao.cadastrarEmpresa(empresa);
		cnpj = empresa.getCnpj();
		System.out.println(cnpj);
		copia.setCnpj(cnpj);
		assertEquals("Testa Criacao", empresa, copia);
	}
	
	@Test
	public void test02Atualizar()
	{
		System.out.println("atualizar");
		empresa.setRazaosocial("Feijao Preto");
		dao.alterarEmpresa(empresa);
		dao.consultarEmpresa(empresa);
		assertEquals("Testa alteração", empresa, copia);	
		
	}
	
	@Test
	public void test03Excluir()
	{
		System.out.println("Excluir");
		copia.setCnpj(-1);
		copia.setRazaosocial(null);
		copia.setHorarioAbertura(null);
		copia.setHorarioFechamento(null);
		dao.excluirEmpresa(empresa);
		dao.consultarEmpresa(empresa);
		assertEquals("Testa exclusao", empresa, copia);	
	}

}
