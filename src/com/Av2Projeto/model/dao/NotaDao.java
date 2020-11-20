package com.Av2Projeto.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Av2Projeto.model.domain.Nota;

public class NotaDao {

	private static final String INSERT_NOTAS_SQL = "insert into nota(av1, av2, av3 ,aps_1, aps_2,media,id_aluno, id_turma)values(?,?,?,?,?,?,?,?)";
	private static final String SELECT_NOTA_BY_ID = "select id_nota,  av1, av2, av3 ,aps_1, aps_2, media ,id_aluno, id_turma from nota where id_nota =?";
	private static final String SELECT_ALL_NOTAS = "select * from nota";
	private static final String DELETE_NOTA_SQL = "delete from nota where id_nota=?";
	private static final String UPDATE_NOTA_SQL = "update nota set av1=?, av2=?, av3=?,aps_1=?, aps_2=?, media=?,id_aluno=?, id_turma=?  where id_nota=?";

	public NotaDao() {
		super();

	}

	// insert nota;
	public void AdicionarNota(Nota nota) throws SQLException, ClassNotFoundException {

		Connection conexao = ConexaoJDBCFactory.getConexao();
		PreparedStatement ps = conexao.prepareStatement(INSERT_NOTAS_SQL);

		ps.setFloat(1, nota.getAv1());
		ps.setFloat(2, nota.getAv2());
		ps.setFloat(3, nota.getAv3());
		ps.setFloat(4, nota.getAps_1());
		ps.setFloat(5, nota.getAps_2());
		ps.setFloat(6, nota.getMedia());
		ps.setInt(7, nota.getId_aluno());
		ps.setInt(8, nota.getId_turma());

		 System.out.println("Notas Dao av1"+nota.getAv1());
	        System.out.println("Notas Dao av2"+nota.getAv2());
	        System.out.println("Notas Dao av3"+nota.getAv3());
	        System.out.println("Notas Dao aps_1"+nota.getAps_1());
	        System.out.println("Notas Dao aps_2"+nota.getAps_2());
	        System.out.println("Notas Dao media"+nota.getMedia());
		ps.execute();
	

	}

// select aluno por ID
	public Nota selectById(Integer id_nota) throws SQLException, ClassNotFoundException {
		Nota nota = null;
		Connection conexao = ConexaoJDBCFactory.getConexao();

		PreparedStatement ps = conexao.prepareStatement(SELECT_NOTA_BY_ID);

		ps.setInt(1, id_nota);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {

			float av1 = rs.getFloat("av1");
			float av2 = rs.getFloat("av2");
			float av3 = rs.getFloat("av3");
			float aps_1 = rs.getFloat("aps_1");
			float aps_2 = rs.getFloat("aps_2");
			float media = rs.getFloat("media");
			int id_aluno = rs.getInt("id_aluno");
			int id_turma = rs.getInt("id_turma");

			nota = new Nota(id_nota, av1, av2, av3, aps_1, aps_2, media, id_aluno, id_turma);
			
		}

	
		return nota;

	}

	// select todos os Alunos
	public List<Nota> listarNotas() throws SQLException, ClassNotFoundException {

		Connection conexao = ConexaoJDBCFactory.getConexao();
		List<Nota> nota = new ArrayList<>();
		PreparedStatement ps = conexao.prepareStatement(SELECT_ALL_NOTAS);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			int id_nota = rs.getInt("id_nota");
			float av1 = rs.getFloat("av1");
			float av2 = rs.getFloat("av2");
			float av3 = rs.getFloat("av3");
			float aps_1 = rs.getFloat("aps_1");
			float aps_2 = rs.getFloat("aps_2");
			float media = rs.getFloat("media");
			int id_aluno = rs.getInt("id_aluno");
			int id_turma = rs.getInt("id_turma");

			nota.add(new Nota(id_nota, av1, av2, av3, aps_1, aps_2, media, id_aluno, id_turma));
			
		}
		
		return nota;
	}

	// Editar Aluno

	public boolean atualizarNota(Nota nota) throws SQLException, ClassNotFoundException {
		boolean rowUpdate;
		Connection conexao = ConexaoJDBCFactory.getConexao();

		PreparedStatement ps = conexao.prepareStatement(UPDATE_NOTA_SQL);

		ps.setFloat(1, nota.getAv1());
		ps.setFloat(2, nota.getAv2());
		ps.setFloat(3, nota.getAv3());
		ps.setFloat(4, nota.getAps_1());
		ps.setFloat(5, nota.getAps_2());
		ps.setFloat(6, nota.getMedia());
		ps.setInt(7, nota.getId_aluno());
		ps.setInt(8, nota.getId_turma());
		ps.setInt(9, nota.getId_nota());

		rowUpdate = ps.executeUpdate() > 0;

		
		return rowUpdate;

	}

	public boolean excluirNota(Integer id_nota) throws SQLException, ClassNotFoundException {
		boolean rowDeletada;

		Connection conexao = ConexaoJDBCFactory.getConexao();
		PreparedStatement statement = conexao.prepareStatement(DELETE_NOTA_SQL);

		statement.setInt(1, id_nota);

		rowDeletada = statement.executeUpdate() > 0;
		
		return rowDeletada;

	}
	

	

}
