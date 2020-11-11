package com.Av2Projeto.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoJDBCFactory {

	public static Connection getConexao() throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/trabalho_academico", "root", "1234");
	}

}

