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

import com.Av2Projeto.model.dao.ConexaoJDBCFactory;
import com.Av2Projeto.model.dao.LoginDao;
import com.Av2Projeto.model.domain.Login;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = { "/validar","/cadastrarLogin","/novoLogin","/showLogin"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private LoginDao loginDao = new LoginDao();
	

	public void init() throws ServletException {
		
		  try { criarDatabase(); } catch (ClassNotFoundException | ServletException |
		  IOException | SQLException e) { // TODO Auto-generated catch block
		  e.printStackTrace(); }
		 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	       
	
		String acao = request.getServletPath();

		switch (acao) {

		case "/novoLogin":
			showCadastroLogin(request, response);

			break;
		case "/showLogin":
			showLogin(request, response);

			break;
		case "/validar":
		
			try {
				validarLogin(request, response);
			} catch (ClassNotFoundException | SQLException | IOException | ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			break;
			
		case "/cadastrarLogin":
			try {
				cadastrarLogin(request, response);
			} catch (ClassNotFoundException | SQLException | IOException | ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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

		
			
			 
		/*
		 * case "/CriarUsuario": CriarUsuario(request, response); break; case
		 * "/InserirDadosAutomaticos": inserirDados(request, response); break;
		 */
		}

	}

	// FORMULARIO ALUNO
	private void showCadastroLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastrarLogin.jsp");
		dispatcher.forward(request, response);
		
	}
	
	  private void showLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
		dispatcher.forward(request, response);
		
	}
	// ADICIONAR
	private void validarLogin(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException, IOException, ServletException {
		
		

			String matricula = request.getParameter("matricula");
			String senha = request.getParameter("senha");

			Login login = new Login(matricula,senha);
			
			System.out.println("matricula" + matricula);
			System.out.println("senha" + senha);

			if (loginDao.validar(login)) {
				request.getRequestDispatcher("menu.jsp").forward(request, response);
			} else {

				request.getRequestDispatcher("login.jsp").forward(request, response);
				;
			}	
		}
	private void cadastrarLogin(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException, IOException, ServletException {
		
			String matricula = request.getParameter("matricula");
			String senha = request.getParameter("senha");

			Login login = new Login(matricula,senha);
			
			System.out.println("matricula" + matricula);
			System.out.println("senha" + senha);

			loginDao.AdicionarLogin(login);
			
			request.getRequestDispatcher("login.jsp").forward(request, response);
				
	}

	// DELETAR ALUNO
	private void delatarLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String matricula = (request.getParameter("matricula"));

		try {
			loginDao.excluirLogin(matricula);

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

		String matricula = (request.getParameter("matricula"));
		Login existelogin;
		try {
			existelogin = loginDao.selectById(matricula);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/nota-list.jsp");
			request.setAttribute("login", existelogin);
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

		String matricula = request.getParameter("matricula");
		String senha = request.getParameter("senha");
		

		Login login = new Login(matricula, senha);

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
		protected void criarDatabase()
				throws ServletException, IOException, ClassNotFoundException, SQLException {
			
		
			 ConexaoJDBCFactory cria = new ConexaoJDBCFactory();
			          cria.conexaoComServidor();
			          cria.Cria_Database_Completa(); 
			         cria.insere_dados();
			        
			
			  
			 
		
		
		
	}

}
