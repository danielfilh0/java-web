package br.edu.ifce.lab3;

import java.io.IOException;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PagMail
 */
public class PagMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PagMail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	/*
	 * protected void service(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { String user = (String)
	 * request.getSession().getAttribute("usuario"); PrintWriter out =
	 * response.getWriter();
	 * 
	 * if(user == null) { RequestDispatcher dispatcher =
	 * request.getRequestDispatcher("formlogin.html"); dispatcher.forward(request,
	 * response); } }
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emailUser = request.getParameter("emailUser");

		String senhaEmail = request.getParameter("senhaEmail");
		
		String emailDestino = request.getParameter("emailDestino");
		
		String titulo = request.getParameter("titulo");
		
		String mensagem = request.getParameter("mensagem");
		
		SimpleEmail email = new SimpleEmail();

		try {
		email.setDebug(true);
		email.setHostName("smtp.gmail.com");
		email.setAuthentication(emailUser,senhaEmail);
		email.setSSL(true);
		email.addTo(emailDestino); //pode ser qualquer um email
		email.setFrom(emailUser); //aqui necessita ser o email que voce fara a autenticacao
		email.setSubject(titulo);
		email.setMsg(mensagem);
		email.send();

		} catch (EmailException e) {

		System.out.println(e.getMessage());

		} 
		

	}

}
