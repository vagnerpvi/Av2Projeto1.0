package com.Av2Projeto.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Av2Projeto.model.dao.AlunoDao;
import com.Av2Projeto.model.domain.Aluno;

/**
 * Servlet implementation class AlunoServlet
 */
@WebServlet(urlPatterns={"/aluno","/novoAluno","/inserirAluno","/deletarAluno","/editarAluno","/atualizarAluno","/listaAlunos"})
public class AlunoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private AlunoDao alunoDao = new AlunoDao();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/aluno.jsp");
		dispatcher.forward(request, response);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getServletPath();

		switch (acao) {

		case "/novoAluno":
			showNewForm(request, response);

			break;
		case "/inserirAluno":
			adicionarAluno(request, response);
			break;

		case "/deletarAluno":
			delatarAluno(request, response);
			break;

		case "/editarAluno":
			editarAluno(request, response);
			break;

		case "/atualizarAluno":
			atualizarAluno(request, response);
			break;

		default:
			listarAluno(request, response);
			break;

		}

	}

	// FORMULARIO ALUNO
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/aluno.jsp");
		dispatcher.forward(request, response);
	}

	// ADICIONAR
	private void adicionarAluno(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = request.getParameter("nome");
		String curso = request.getParameter("curso");
		Integer id_professor = Integer.parseInt(request.getParameter("id_professor"));

		Aluno aluno = new Aluno(null, nome, curso, id_professor);

		try {
			alunoDao.AdicionarAluno(aluno);
			response.sendRedirect("listaAlunos");
			request.setAttribute("mensagem", "Aluno Salvo com Sucesso");
		} catch (SQLException e) {
			request.setAttribute("mensagem", "ERRO DE BANCO DE DADOS" + e.getMessage());
		} catch (ClassNotFoundException e) {
			request.setAttribute("mensagem", "ERRO DE DRIVE" + e.getMessage());

		}

	}

	// DELETAR ALUNO
	private void delatarAluno(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id_aluno = Integer.parseInt(request.getParameter("id_aluno"));

		try {
			alunoDao.excluirAluno(id_aluno);

			response.sendRedirect("listaAlunos");

			request.setAttribute("mensagem", "Aluno Excluido Com sucesso");
		} catch (SQLException e) {
			request.setAttribute("mensagem", "ERRO DE BANCO DE DADOS" + e.getMessage());
		} catch (ClassNotFoundException e) {
			request.setAttribute("mensagem", "ERRO DE DRIVE" + e.getMessage());

		}

	}

	// EDITAR
	private void editarAluno(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id_aluno = Integer.parseInt(request.getParameter("id_aluno"));
		Aluno existeAluno;
		try {
			existeAluno = alunoDao.selectById(id_aluno);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/aluno.jsp");
			request.setAttribute("aluno", existeAluno);
			dispatcher.forward(request, response);
			request.setAttribute("mensagem", "Aluno atualizado com Sucesso");
			request.setAttribute("aluno", alunoDao.listarAlunos());
		} catch (SQLException e) {
			request.setAttribute("mensagem", "ERRO DE BANCO DE DADOS" + e.getMessage());
		} catch (ClassNotFoundException e) {
			request.setAttribute("mensagem", "ERRO DE DRIVE" + e.getMessage());

		}

	}

	// ATUALIVAR ALUNO
	private void atualizarAluno(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer id_aluno = Integer.parseInt(request.getParameter("id_aluno"));
		String nome = request.getParameter("nome");
		String curso = request.getParameter("curso");
		Integer id_professor = Integer.parseInt(request.getParameter("id_professor"));

		Aluno aluno = new Aluno(id_aluno, nome, curso, id_professor);

		try {
			alunoDao.atualizarAluno(aluno);
			
			response.sendRedirect("listaAlunos");

		} catch (ClassNotFoundException e) {
			request.setAttribute("mensagem", "ERRO DE DRIVE" + e.getMessage());
		} catch (SQLException e) {
			request.setAttribute("mensagem", "ERRO DE BANCO DE DADOS" + e.getMessage());
		}

	}

	protected void listarAluno(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<Aluno> listaAlunos = alunoDao.listarAlunos();
			request.setAttribute("listaAlunos", listaAlunos);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/aluno-list.jsp");
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
