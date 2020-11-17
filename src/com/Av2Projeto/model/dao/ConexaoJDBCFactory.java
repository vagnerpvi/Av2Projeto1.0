package com.Av2Projeto.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConexaoJDBCFactory {

	static String drive = "com.mysql.jdbc.Driver";
	static String server = "localhost:3306";
	static String database = "trabalho_academico";
	static String url = "jdbc:mysql://" + server + "/" + database;
	static String urlConexaoServidor = "jdbc:mysql://" + server + "/";
	static String password = "1234";
	static String username = "root";

	static private Connection conexaoComServidor;

	public static Connection getConexao() throws SQLException, ClassNotFoundException {

		Class.forName(drive);

		Connection conexao = DriverManager.getConnection(url, username, password);

		return conexao;

	}

	// ------------------------------------------------------------------------------------------

	public Boolean conexaoComServidor() throws SQLException, ClassNotFoundException {

		boolean conectado = false;

		try {
			Class.forName(drive);
			conexaoComServidor = DriverManager.getConnection(urlConexaoServidor, username, password);
			conectado = true;
		} catch (ClassNotFoundException fonte) {
			System.out.println("Drive não Localizado" + fonte);
		} catch (SQLException fonte) {

		}
		return conectado;

	}

	// ------------------------------------------------------------------------------------------
	private void Fecha_conexao() {
		try {
			Connection conexao = ConexaoJDBCFactory.getConexao();
			conexao.close();
		} catch (Exception fechada) {
			System.out.println("Erro ao fechar Conexao Com o Banco " + fechada);
		}

	}

	// ------------------------------------------------------------------------------------------

	public boolean Cria_Database_Completa() throws ClassNotFoundException, SQLException {
		boolean criadaComSucesso = true;
		if (conexaoComServidor()) {
			if (!CriaDatabase()) {
				criar_usuario();
				criadaComSucesso = false;
			} else if (!CriaTabelas()) {
				criadaComSucesso = false;
			}

		}
		return criadaComSucesso;
	}

	// ------------------------------------------------------------------------------------------
	public boolean CriaDatabase() throws ClassNotFoundException {
		boolean conectado = false;

		String sql = "CREATE DATABASE IF NOT EXISTS `trabalho_academico` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;";

		try {
			Connection conexaoServidor = ConexaoJDBCFactory.conexaoComServidor;
			PreparedStatement ps = conexaoServidor.prepareStatement(sql);
			ps.execute();
			conectado = true;

		} catch (SQLException e) {
			System.out.println("Banco de Dados não foi Criado" + e);
		}
		return conectado;
	}

	public boolean CriaTabelas() throws ClassNotFoundException, SQLException {
		boolean tabCriada = false;

		try {
			if (!cria_tabela_turma()) {
				tabCriada = false;
			} else if (!cria_tabela_professor()) {
				tabCriada = false;
			} else if (!cria_tabela_aluno()) {
				tabCriada = false;
			} else if (!cria_tabela_disciplina()) {
				tabCriada = false;
			} else if (!cria_tabela_aluno_disciplina()) {
				tabCriada = false;
			} else if (!cria_tabela_nota()) {
				tabCriada = false;
			} else if (!cria_tabela_login()) {
				tabCriada = false;
			}

			insere_dados();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tabCriada;
	}

	private boolean cria_tabela_turma() throws ClassNotFoundException, SQLException {

		boolean tabCriada = false;
		String sql = "CREATE TABLE IF NOT EXISTS `trabalho_academico`.`turma` (\r\n" + "  `id_turma` INT NOT NULL,\r\n"
				+ "  `periodoLetivo` varchar(100) NOT NULL,\r\n" + "  `tipo` varchar(100) not null,\r\n"
				+ "  PRIMARY KEY (`id_turma`))\r\n" + "ENGINE = InnoDB\r\n" + "DEFAULT CHARACTER SET = utf8mb4\r\n"
				+ "COLLATE = utf8mb4_0900_ai_ci;";
		Connection conexao = ConexaoJDBCFactory.getConexao();
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.execute();

		tabCriada = true;

		return tabCriada;
	}

	private boolean cria_tabela_professor() throws ClassNotFoundException, SQLException {

		boolean tabCriada = false;
		String sql = "CREATE TABLE IF NOT EXISTS `trabalho_academico`.`professor` (\r\n"
				+ "  `id_professor` INT NOT NULL,\r\n" + "  `nome` VARCHAR(40) NOT NULL,\r\n"
				+ "  `titulacao` VARCHAR(50) NOT NULL,\r\n" + "  `id_turma` INT,\r\n"
				+ "  PRIMARY KEY (`id_professor`),\r\n" + "  FOREIGN KEY (`id_turma`)\r\n"
				+ "REFERENCES `trabalho_academico`.`turma` (`id_turma`)\r\n" + " ON DELETE SET NULL\r\n"
				+ " ON UPDATE CASCADE\r\n" + ")ENGINE = InnoDB\r\n" + "DEFAULT CHARACTER SET = utf8mb4\r\n"
				+ "COLLATE = utf8mb4_0900_ai_ci;";
		Connection conexao = ConexaoJDBCFactory.getConexao();
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.execute();

		tabCriada = true;

		return tabCriada;
	}

	private boolean cria_tabela_aluno() throws ClassNotFoundException, SQLException {

		boolean tabCriada = false;
		String sql = "CREATE TABLE IF NOT EXISTS `trabalho_academico`.`aluno` (\r\n" + "  `id_aluno` INT NOT NULL,\r\n"
				+ "  `nome` VARCHAR(40) ,\r\n" + "  `curso` VARCHAR(50) ,\r\n" + "  `id_professor` INT,\r\n"
				+ "  PRIMARY KEY (`id_aluno`),\r\n" + "    FOREIGN KEY (`id_professor`)\r\n"
				+ "    REFERENCES `trabalho_academico`.`professor` (`id_professor`)\r\n" + " ON DELETE SET NULL\r\n"
				+ " ON UPDATE CASCADE\r\n" + ")ENGINE = InnoDB\r\n" + "DEFAULT CHARACTER SET = utf8mb4\r\n"
				+ "COLLATE = utf8mb4_0900_ai_ci;";
		Connection conexao = ConexaoJDBCFactory.getConexao();
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.execute();

		tabCriada = true;

		return tabCriada;
	}

	private boolean cria_tabela_disciplina() throws ClassNotFoundException, SQLException {

		boolean tabCriada = false;
		String sql = "CREATE TABLE IF NOT EXISTS `trabalho_academico`.`disciplina` (\r\n"
				+ "  `id_disciplina` INT NOT NULL,\r\n" + "  `nome` VARCHAR(40) NOT NULL,\r\n"
				+ "  `carga` SMALLINT NOT NULL,\r\n" + "   `id_turma` INT,\r\n" + "  PRIMARY KEY (`id_disciplina`),\r\n"
				+ "   FOREIGN KEY (`id_turma`)\r\n" + "    REFERENCES `trabalho_academico`.`turma` (`id_turma`)\r\n"
				+ "  ON DELETE CASCADE\r\n" + " ON UPDATE CASCADE\r\n" + ")ENGINE = InnoDB\r\n"
				+ "DEFAULT CHARACTER SET = utf8mb4\r\n" + "COLLATE = utf8mb4_0900_ai_ci;";
		Connection conexao = ConexaoJDBCFactory.getConexao();
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.execute();

		tabCriada = true;

		return tabCriada;
	}

	private boolean cria_tabela_aluno_disciplina() throws ClassNotFoundException, SQLException {

		boolean tabCriada = false;
		String sql = "CREATE TABLE IF NOT EXISTS `trabalho_academico`.`aluno_disciplina` (\r\n"
				+ "  `id_aluno` INT NOT NULL,\r\n" + "  `id_disciplina` INT NOT NULL,\r\n"
				+ "  PRIMARY KEY (`id_aluno`, `id_disciplina`),\r\n" + "    FOREIGN KEY (`id_aluno`)\r\n"
				+ "    REFERENCES `trabalho_academico`.`aluno` (`id_aluno`),\r\n"
				+ "    FOREIGN KEY (`id_disciplina`)\r\n"
				+ "    REFERENCES `trabalho_academico`.`disciplina` (`id_disciplina`)\r\n"
				+ "     ON DELETE CASCADE\r\n" + "     ON UPDATE CASCADE\r\n" + ")ENGINE = InnoDB\r\n"
				+ "DEFAULT CHARACTER SET = utf8mb4\r\n" + "COLLATE = utf8mb4_0900_ai_ci;";
		Connection conexao = ConexaoJDBCFactory.getConexao();
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.execute();

		tabCriada = true;

		return tabCriada;
	}

	private boolean cria_tabela_nota() throws ClassNotFoundException, SQLException {

		boolean tabCriada = false;
		String sql = "CREATE TABLE IF NOT EXISTS `trabalho_academico`.`nota` (\r\n" + "  `id_nota` INT NOT NULL,\r\n"
				+ "   `av1` float,\r\n" + "    `av2` float,\r\n" + "    `av3`  float,\r\n" + "	`aps_1` float,\r\n"
				+ "	`aps_2` float,\r\n" + "    `media` float,\r\n" + "    `faltas` int,\r\n" + "  `id_aluno` INT,\r\n"
				+ "  `id_turma` INT,\r\n" + "  PRIMARY KEY (`id_nota`),\r\n" + "   FOREIGN KEY (`id_aluno`)\r\n"
				+ "    REFERENCES `trabalho_academico`.`aluno` (`id_aluno`),\r\n" + "    FOREIGN KEY (`id_turma`)\r\n"
				+ "    REFERENCES `trabalho_academico`.`turma` (`id_turma`)\r\n" + "      ON DELETE CASCADE\r\n"
				+ "     ON UPDATE CASCADE\r\n" + ")ENGINE = InnoDB\r\n" + "DEFAULT CHARACTER SET = utf8mb4\r\n"
				+ "COLLATE = utf8mb4_0900_ai_ci;";
		Connection conexao = ConexaoJDBCFactory.getConexao();
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.execute();

		tabCriada = true;

		return tabCriada;
	}

	private boolean cria_tabela_login() throws ClassNotFoundException, SQLException {

		boolean tabCriada = false;
		String sql = "CREATE TABLE IF NOT EXISTS `trabalho_academico`.`login` (\r\n"
				+ "  `matricula` VARCHAR(100) NOT NULL,\r\n" + "  `senha` VARCHAR(100) NULL,\r\n"
				+ "  PRIMARY KEY (`matricula`)\r\n" + ")ENGINE = InnoDB\r\n" + "DEFAULT CHARACTER SET = utf8mb4\r\n"
				+ "COLLATE = utf8mb4_0900_ai_ci;";
		Connection conexao = ConexaoJDBCFactory.getConexao();
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.execute();

		tabCriada = true;

		return tabCriada;
	}

	private void criar_usuario() throws ClassNotFoundException, SQLException {

		String sql = "CREATE USER 'DBA'@'localhost' IDENTIFIED BY '11111';\r\n"
				+ "	CREATE USER 'DEV'@'localhost' IDENTIFIED BY '22222';\r\n" + "\r\n"
				+ "GRANT ALL PRIVILEGES ON trabalhoa_cademico . * TO 'DBA'@'localhost';\r\n" + "\r\n"
				+ "GRANT SELECT, INSERT,UPDATE ON trabalho_academico.* TO 'DEV'@'localhost';";
		Connection conexao = ConexaoJDBCFactory.getConexao();
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.execute();

	}

	private void insere_dados() throws ClassNotFoundException, SQLException {
		String sql1 = "vagber";
		String sql = "insert into login values('1111','1234');\r\n" + "insert into login values('2222','4321');";
		Connection conexao = ConexaoJDBCFactory.getConexao();
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.execute();

	}

}
