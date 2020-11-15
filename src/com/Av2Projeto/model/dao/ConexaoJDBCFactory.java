package com.Av2Projeto.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoJDBCFactory {

	
	static String drive = "com.mysql.jdbc.Driver";
	static String server = "localhost:3306";
	static String database = "trabalho_academico";
	static String url = "jdbc:mysql://" + server + "/" + database;
	static String password = "1234";
	static String username = "root";

	public static Connection getConexao() throws SQLException, ClassNotFoundException {

		Class.forName(drive);

		Connection conexao = DriverManager.getConnection(url, username, password);

		return conexao;

	}

}
