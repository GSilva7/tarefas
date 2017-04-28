package model.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.javabean.Empresa;
import model.service.EmpresaService;

/**
 * Servlet implementation class AlterarEmpresaController
 */
@WebServlet("/AlterarEmpresa.do")
public class AlterarEmpresaController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String pRazao = request.getParameter("razao");
		String pAbertura = request.getParameter("horarioabertura") + ":00";
		String pFechamento = request.getParameter("horariofechamento") + ":00";
		int pCnpj = Integer.parseInt(request.getParameter("cnpj"));
		
		Empresa empresa = new Empresa();
		empresa.setRazaosocial(pRazao);
		empresa.setHorarioAbertura(Time.valueOf(pAbertura));
		empresa.setHorarioFechamento(Time.valueOf(pFechamento));
		empresa.setCnpj(pCnpj);
		
		EmpresaService service = new EmpresaService();
		service.atualizar(empresa);
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Empresa Cadastrada</title></head><body>");
		out.println( "CNPJ: "+ empresa.getCnpj() + "<br>");
		out.println( "Razão Social: "+ empresa.getRazaosocial() + "<br>");
		out.println( "Horario de Abertura: "+ empresa.getHorarioAbertura().toString() + "<br>");
		out.println( "Horario de Fechamento: "+ empresa.getHorarioFechamento().toString() + "<br>");
		out.println("</body></html>");
	}

}
