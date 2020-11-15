package com.Av2Projeto.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Av2Projeto.model.dao.LoginDao;
import com.Av2Projeto.model.domain.Login;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = { "/login", "/novoLogin", "/inserirLogin", "/deletarLogin", "/editarLogin", "/atualizarLogin",
		"/listaLogin" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private LoginDao loginDao = new LoginDao();

	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getServletPath();

		switch (acao) {

		case "/novoLogin":
			showHome(request, response);

			break;
		case "/inserirLogin":
			adicionarLogin(request, response);
			break;

		case "/deletarLogin":
			delatarLogin(request, response);
			break;

		case "/editarLogin":
			editarLogin(request, response);
			break;

		case "/atualizarLogin":
			atualizarLogin(request, response);
			break;

		case "/listaLogin":
			listarLogin(request, response);
			break;
		default:
			listarLogin(request, response);
			break;

		}

	}

	// FORMULARIO ALUNO
	private void showHome(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
		dispatcher.forward(request, response);
	}

	// ADICIONAR
	private void adicionarLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String matricula = request.getParameter("matricula");
		String senha = request.getParameter("senha");
		Integer id_aluno = Integer.parseInt(request.getParameter("id_aluno"));
		Integer id_professor = Integer.parseInt(request.getParameter("id_professor"));
		
	System.out.println("matricula"+matricula);
	System.out.println("senha"+senha);
	System.out.println("id_aluno"+id_aluno);
	System.out.println("id_professor"+id_professor);
	  

		Login login = new Login(null, matricula, senha, id_aluno, id_professor);

		try {
			loginDao.AdicionarLogin(login);
			//response.sendRedirect("listaLogin");
			request.setAttribute("mensagem", "Login Salvo com Sucesso");
		} catch (SQLException e) {
			request.setAttribute("mensagem", "ERRO DE BANCO DE DADOS" + e.getMessage());
		} catch (ClassNotFoundException e) {
			request.setAttribute("mensagem", "ERRO DE DRIVE" + e.getMessage());

		}

	}

	// DELETAR ALUNO
	private void delatarLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id_login = Integer.parseInt(request.getParameter("id_login"));

		try {
			loginDao.excluirLogin(id_login);

			response.sendRedirect("listaLogin");

			request.setAttribute("mensagem", "Login Excluido Com sucesso");
		} catch (SQLException e) {
			request.setAttribute("mensagem", "ERRO DE BANCO DE DADOS" + e.getMessage());
		} catch (ClassNotFoundException e) {
			request.setAttribute("mensagem", "ERRO DE DRIVE" + e.getMessage());

		}

	}

	// EDITAR
	private void editarLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id_login = Integer.parseInt(request.getParameter("id_login"));
		Login existelogin;
		try {
			existelogin = loginDao.selectById(id_login);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/nota-list.jsp");
			request.setAttribute("nota", existelogin);
			dispatcher.forward(request, response);
			request.setAttribute("mensagem", "Login atualizado com Sucesso");
			request.setAttribute("aluno", loginDao.listarLogin());
		} catch (SQLException e) {
			request.setAttribute("mensagem", "ERRO DE BANCO DE DADOS" + e.getMessage());
		} catch (ClassNotFoundException e) {
			request.setAttribute("mensagem", "ERRO DE DRIVE" + e.getMessage());

		}

	}

	// ATUALIVAR ALUNO
	private void atualizarLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id_login = Integer.parseInt(request.getParameter("id_login"));

		String matricula = request.getParameter("matricula");
		String senha = request.getParameter("senha");
		Integer id_aluno = Integer.parseInt(request.getParameter("id_aluno"));
		Integer id_professor = Integer.parseInt(request.getParameter("id_professor"));

		Login login = new Login(id_login, matricula, senha, id_aluno, id_professor);

		try {
			loginDao.atualizarLogin(login);
			response.sendRedirect("listaLogin");

		} catch (ClassNotFoundException e) {
			request.setAttribute("mensagem", "ERRO DE DRIVE" + e.getMessage());
		} catch (SQLException e) {
			request.setAttribute("mensagem", "ERRO DE BANCO DE DADOS" + e.getMessage());
		}

	}

	protected void listarLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<Login> listaLogin = loginDao.listarLogin();
			request.setAttribute("listaLogin", listaLogin);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/nota-list.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	

}
