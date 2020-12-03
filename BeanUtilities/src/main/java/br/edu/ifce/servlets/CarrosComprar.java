package br.edu.ifce.servlets;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifce.bean.Carros;
import br.edu.ifce.utils.BeanUtilities;

/**
 * Servlet implementation class CarrosComprar
 */
public class CarrosComprar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarrosComprar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Primeira Forma 
		
		Enumeration parametros = request.getParameterNames();
		/*
		 * while (parametros.hasMoreElements()) { String parametro = (String)
		 * parametros.nextElement(); String valor = request.getParameter(parametro);
		 * System.out.println(parametro + ": "+valor); }
		 */
		
		// Segunda Forma
		
		/*
		 * while (parametros.hasMoreElements()) { String parametro = (String)
		 * parametros.nextElement(); String [] valores =
		 * request.getParameterValues(parametro); for (int i = 0; i < valores.length;
		 * i++) { System.out.println(valores[i]); } }
		 */
		
		// Terceira Forma
		Carros c = new Carros();
		BeanUtilities.populateBean(c, request);
		System.out.println(c.getMarca() + " " + c.getModelo() + " " + c.getAno());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
