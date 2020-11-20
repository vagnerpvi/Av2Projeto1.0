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

import com.Av2Projeto.model.dao.NotaDao;

import com.Av2Projeto.model.domain.Nota;

/**
 * Servlet implementation class NotaServlet
 */
@WebServlet(urlPatterns = { "/nota", "/home", "/inserirNota", "/deletarNota", "/editarNota", "/atualizarNota",
		"/listaNotas" })
public class NotaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private NotaDao notaDao;

	public void init() {

		notaDao = new NotaDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/menu.jsp");
		dispatcher.forward(request, response);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getServletPath();

		switch (acao) {

		case "/home":
			showHome(request, response);

			break;
		case "/inserirNota":
			adicionarNota(request, response);
			break;

		case "/deletarNota":
			delatarNota(request, response);
			break;

		case "/editarNota":
			editarNota(request, response);
			break;

		case "/atualizarNota":
			atualizarNota(request, response);
			break;

		case "/listaNotas":
			listarNotas(request, response);
			break;
		default:
			listarNotas(request, response);
			break;

		}

	}

	// FORMULARIO ALUNO
	private void showHome(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/menu.jsp");
		dispatcher.forward(request, response);
	}

	// ADICIONAR
	private void adicionarNota(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		float av1 = Float.parseFloat(request.getParameter("av1"));
		float av2 = Float.parseFloat(request.getParameter("av2"));
		float av3 = Float.parseFloat(request.getParameter("av3"));
		float aps_1 = Float.parseFloat(request.getParameter("aps_1"));
		float aps_2 = Float.parseFloat(request.getParameter("aps_2"));
		float media = CalculaMedia(av1, av2, av3, aps_1, aps_2);
		Integer id_aluno = Integer.parseInt(request.getParameter("id_aluno"));
		Integer id_turma = Integer.parseInt(request.getParameter("id_turma"));
		System.out.println("Notas ServLet av1-" + av1);
		System.out.println("Notas ServLet av2-" + av2);
		System.out.println("Notas ServLet av3-" + av3);
		System.out.println("Notas ServLet aaps_1-" + aps_1);
		System.out.println("Notas ServLet aps_2-" + aps_2);
		System.out.println("Notas ServLet media-" + media);
           
		Nota nota = new Nota(null, somaAv1(av1,aps_1),somaAv2(av2,aps_2), av3, aps_1, aps_2, media, id_aluno, id_turma);

		try {
			notaDao.AdicionarNota(nota);
			response.sendRedirect("listaNotas");
			request.setAttribute("mensagem", "Aluno Salvo com Sucesso");
		} catch (SQLException e) {
			request.setAttribute("mensagem", "ERRO DE BANCO DE DADOS" + e.getMessage());
		} catch (ClassNotFoundException e) {
			request.setAttribute("mensagem", "ERRO DE DRIVE" + e.getMessage());

		}

	}


	// DELETAR ALUNO
	private void delatarNota(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id_nota = Integer.parseInt(request.getParameter("id_nota"));

		try {
			notaDao.excluirNota(id_nota);

			response.sendRedirect("listaNotas");

			request.setAttribute("mensagem", "Aluno Excluido Com sucesso");
		} catch (SQLException e) {
			request.setAttribute("mensagem", "ERRO DE BANCO DE DADOS" + e.getMessage());
		} catch (ClassNotFoundException e) {
			request.setAttribute("mensagem", "ERRO DE DRIVE" + e.getMessage());

		}

	}

	// EDITAR
	private void editarNota(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id_nota = Integer.parseInt(request.getParameter("id_nota"));
		Nota existeNota;
		try {
			existeNota = notaDao.selectById(id_nota);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/nota-list.jsp");
			request.setAttribute("nota", existeNota);
			dispatcher.forward(request, response);
			request.setAttribute("mensagem", "Aluno atualizado com Sucesso");
			request.setAttribute("aluno", notaDao.listarNotas());
		} catch (SQLException e) {
			request.setAttribute("mensagem", "ERRO DE BANCO DE DADOS" + e.getMessage());
		} catch (ClassNotFoundException e) {
			request.setAttribute("mensagem", "ERRO DE DRIVE" + e.getMessage());

		}

	}

	// ATUALIVAR ALUNO
	private void atualizarNota(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id_nota = Integer.parseInt(request.getParameter("id_nota"));
		float av1 = Float.parseFloat(request.getParameter("av1"));
		float av2 = Float.parseFloat(request.getParameter("av2"));
		float av3 = Float.parseFloat(request.getParameter("av3"));
		float aps_1 = Float.parseFloat(request.getParameter("aps_1"));
		float aps_2 = Float.parseFloat(request.getParameter("aps_2"));
		Integer id_aluno = Integer.parseInt(request.getParameter("id_aluno"));
		Integer id_turma = Integer.parseInt(request.getParameter("id_turma"));
		float media = 0;
		Nota nota = new Nota(id_nota, av1, av2, av3, aps_1, aps_2, media, id_aluno, id_turma);

		try {
			notaDao.atualizarNota(nota);
			response.sendRedirect("listaNotas");

		} catch (ClassNotFoundException e) {
			request.setAttribute("mensagem", "ERRO DE DRIVE" + e.getMessage());
		} catch (SQLException e) {
			request.setAttribute("mensagem", "ERRO DE BANCO DE DADOS" + e.getMessage());
		}

	}

	protected void listarNotas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<Nota> listaNotas = notaDao.listarNotas();
			request.setAttribute("listaNotas", listaNotas);
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

	private float CalculaMedia(float av1, float av2, float av3, float aps_1, float aps_2) {

		float avaliacao1, avaliacao2, avaliacao3, media;

		avaliacao1 = av1 + aps_1;
		avaliacao2 = av2+ aps_2;
		avaliacao3 = av3;

		Float[] nota = { avaliacao1, avaliacao2, avaliacao3 };

		float maior = 0, menor = 0, meio = 0;
		for (int i = 0; i < nota.length; i++) {
			menor = nota[1];
			meio = nota[1];
			if (nota[i] > maior) {
				maior = nota[i];
			} else if (nota[i] < menor) {
				menor = nota[i];
			} else if (nota[i] < maior && nota[i] > menor) {

			}
			System.out.println("maior" + maior);
			System.out.println("menor" + menor);
			System.out.println("meio" + meio);
		}
		media = (maior + meio) / 2;

		System.out.println("media Calculada" + media);
		return media;
	}
	
	private float somaAv1(float av1, float aps_1) {
	float av1Somada =av1+aps_1;
		return av1Somada;
	}
	
	private float somaAv2(float av2, float aps_2) {
		float av2Somada =av2+aps_2;
		return av2Somada;
	}

}
