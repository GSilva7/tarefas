package model.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.javabean.Empresa;
import model.service.EmpresaService;

/**
 * Servlet implementation class ConsultarEmpresaController
 */
@WebServlet("/ConsultarEmpresa.do")
public class ConsultarEmpresaController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pCnpj = Integer.parseInt(request.getParameter("cnpj"));
		
		Empresa empresa = new Empresa();
		empresa.setCnpj(pCnpj);
		EmpresaService service = new EmpresaService();
		service.carregar(empresa);
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Empresa</title></head><body>");
		out.println( "CNPJ: "+ empresa.getCnpj() + "<br>");
		out.println( "Raz�o Social: "+ empresa.getRazaosocial() + "<br>");
		out.println( "Horario de Abertura: "+ empresa.getHorarioAbertura().toString() + "<br>");
		out.println( "Horario de Fechamento: "+ empresa.getHorarioFechamento().toString() + "<br>");
		out.println("</body></html>");
	}

}
