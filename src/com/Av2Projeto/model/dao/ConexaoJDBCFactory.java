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
	static String password = "11111";
	static String username = "DBA";

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
		boolean criada = false;

		String sql = "CREATE DATABASE IF NOT EXISTS `trabalho_academico` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;";

		try {
			Connection conexaoServidor = ConexaoJDBCFactory.conexaoComServidor;
			PreparedStatement ps = conexaoServidor.prepareStatement(sql);
			ps.execute();
			criada = true;

		} catch (SQLException e) {
			System.out.println("Banco de Dados não foi Criado" + e);
		}
		return criada;
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

			// insere_dados();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tabCriada;
	}

	private boolean cria_tabela_turma() throws ClassNotFoundException, SQLException {

		boolean tabCriada = false;
		String sql = "CREATE TABLE IF NOT EXISTS `trabalho_academico`.`turma` (\r\n"
				+ "  `id_turma` INT NOT NULL AUTO_INCREMENT ,\r\n" + "  `periodoLetivo` varchar(100),\r\n"
				+ "  `tipo` varchar(100),\r\n" + "  PRIMARY KEY (`id_turma`))\r\n" + "ENGINE = InnoDB\r\n"
				+ "DEFAULT CHARACTER SET = utf8mb4\r\n" + "COLLATE = utf8mb4_0900_ai_ci;";
		Connection conexao = ConexaoJDBCFactory.getConexao();
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.execute();

		tabCriada = true;

		return tabCriada;
	}

	private boolean cria_tabela_professor() throws ClassNotFoundException, SQLException {

		boolean tabCriada = false;
		String sql = "CREATE TABLE IF NOT EXISTS `trabalho_academico`.`professor` (\r\n"
				+ "  `id_professor` INT NOT NULL AUTO_INCREMENT ,\r\n" + "  `nome` VARCHAR(40) NOT NULL,\r\n"
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
		String sql = "CREATE TABLE IF NOT EXISTS `trabalho_academico`.`aluno` (\r\n"
				+ "  `id_aluno` INT NOT NULL AUTO_INCREMENT ,\r\n" + "  `nome` VARCHAR(40) ,\r\n"
				+ "  `curso` VARCHAR(50) ,\r\n" + "  `id_professor` INT,\r\n" + "  PRIMARY KEY (`id_aluno`),\r\n"
				+ "    FOREIGN KEY (`id_professor`)\r\n"
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
				+ "  `id_disciplina` INT NOT NULL AUTO_INCREMENT ,\r\n" + "  `nome` VARCHAR(40) NOT NULL,\r\n"
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
				+ "  `id_aluno_disciplina` INT NOT NULL AUTO_INCREMENT,\r\n" + "  `id_aluno` INT NOT NULL,\r\n"
				+ "  `id_disciplina` INT NOT NULL,\r\n" + "  PRIMARY KEY ( `id_aluno_disciplina`),\r\n"
				+ "    FOREIGN KEY (`id_aluno`)\r\n" + "    REFERENCES `trabalho_academico`.`aluno` (`id_aluno`),\r\n"
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
		String sql = "CREATE TABLE IF NOT EXISTS `trabalho_academico`.`nota` (\r\n"
				+ "  `id_nota` INT NOT NULL AUTO_INCREMENT ,\r\n" + "   `av1` float,\r\n" + "    `av2` float,\r\n"
				+ "    `av3`  float,\r\n" + "	`aps_1` float,\r\n" + "	`aps_2` float,\r\n" + "    `media` float,\r\n"
				+ "  `id_aluno` INT,\r\n" + "  `id_turma` INT,\r\n" + "  PRIMARY KEY (`id_nota`),\r\n"
				+ "   FOREIGN KEY (`id_aluno`)\r\n" + "    REFERENCES `trabalho_academico`.`aluno` (`id_aluno`),\r\n"
				+ "    FOREIGN KEY (`id_turma`)\r\n" + "    REFERENCES `trabalho_academico`.`turma` (`id_turma`)\r\n"
				+ "      ON DELETE CASCADE\r\n" + "     ON UPDATE CASCADE\r\n" + ")ENGINE = InnoDB\r\n"
				+ "DEFAULT CHARACTER SET = utf8mb4\r\n" + "COLLATE = utf8mb4_0900_ai_ci;";
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
				+ "  PRIMARY KEY (`matricula`)\r\n" + "  )ENGINE = InnoDB\r\n" + "  DEFAULT CHARACTER SET = utf8mb4\r\n"
				+ "  COLLATE = utf8mb4_0900_ai_ci;";
		Connection conexao = ConexaoJDBCFactory.getConexao();
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.execute();

		tabCriada = true;

		return tabCriada;
	}

	private void criar_usuario() throws ClassNotFoundException, SQLException {

		Connection conexao = ConexaoJDBCFactory.getConexao();

		String sqluser1 = "CREATE USER 'DBA'@'localhost' IDENTIFIED BY '1111';";
		PreparedStatement ps = conexao.prepareStatement(sqluser1);
		ps.execute();

		String sqlprevilegios1 = "GRANT ALL PRIVILEGES ON trabalhoa_cademico . * TO 'DBA'@'localhost';";
		PreparedStatement ps1 = conexao.prepareStatement(sqlprevilegios1);
		ps1.execute();

		String sqluser2 = "	CREATE USER 'DEV'@'localhost' IDENTIFIED BY '2222';";
		PreparedStatement psu = conexao.prepareStatement(sqluser2);
		psu.execute();

		String sqlprevilegios2 = "GRANT SELECT, INSERT,UPDATE ON trabalho_academico.* TO 'DEV'@'localhost';";
		PreparedStatement ps2 = conexao.prepareStatement(sqlprevilegios2);
		ps2.execute();

	}

	public void insere_dados() throws ClassNotFoundException, SQLException {

		Connection conexao = ConexaoJDBCFactory.getConexao();

		String sqlt = "insert into turma values (1,'5','Presencial');";
		String sqlt1 = "insert into turma values (2,'6','EAD');";
		String sqlt2 = "insert into turma values (3,'1','Presencial');";

		PreparedStatement ps = conexao.prepareStatement(sqlt);
		PreparedStatement ps1 = conexao.prepareStatement(sqlt1);
		PreparedStatement ps2 = conexao.prepareStatement(sqlt2);
		ps.execute();
		ps1.execute();
		ps2.execute();

		String sqlp = "insert into professor values (1,'Manoel','Dr',1);";
		String sqlp1 = "insert into professor values (2,'Tavares','Dr',2);";
		String sqlp2 = "insert into professor values (3,'Zanetti','Dr',2);";

		PreparedStatement ps3 = conexao.prepareStatement(sqlp);
		PreparedStatement ps4 = conexao.prepareStatement(sqlp1);
		PreparedStatement ps5 = conexao.prepareStatement(sqlp2);
		ps3.execute();
		ps4.execute();
		ps5.execute();

		String sqld = "insert into disciplina values (1,'Algoritm',60,1);";
		String sqld1 = "insert into disciplina values (2,'Redes',60,2);";
		String sqld2 = "insert into disciplina values (3,'Engenharia',60,3);";

		PreparedStatement ps6 = conexao.prepareStatement(sqld);
		PreparedStatement ps7 = conexao.prepareStatement(sqld1);
		PreparedStatement ps8 = conexao.prepareStatement(sqld2);
		ps6.execute();
		ps7.execute();
		ps8.execute();

		String sqla = " insert into aluno values (1,'Paulo','CC',1);";
		String sqla1 = "insert into aluno values (2,'Manoel','Redes',1);";
		String sqla2 = "insert into aluno values (3,'Pedro','CC',2);";
		String sqla3 = "insert into aluno values (4,'Maria','Redes',2);";

		PreparedStatement ps9 = conexao.prepareStatement(sqla);
		PreparedStatement ps10 = conexao.prepareStatement(sqla1);
		PreparedStatement ps11 = conexao.prepareStatement(sqla2);
		PreparedStatement ps12 = conexao.prepareStatement(sqla3);
		ps9.execute();
		ps10.execute();
		ps11.execute();
		ps12.execute();

		String sqlad = "insert into  aluno_disciplina values (1,1,2);";
		String sqlad1 = "insert into  aluno_disciplina values (2,1,1);";
		String sqlad2 = "insert into  aluno_disciplina values (3,2,2);";
		String sqlad3 = "insert into  aluno_disciplina values (4,3,1);";

		PreparedStatement ps14 = conexao.prepareStatement(sqlad);
		PreparedStatement ps15 = conexao.prepareStatement(sqlad1);
		PreparedStatement ps16 = conexao.prepareStatement(sqlad2);
		PreparedStatement ps17 = conexao.prepareStatement(sqlad3);

		ps14.execute();
		ps15.execute();
		ps16.execute();
		ps17.execute();

		String sqln = "insert into nota values(1,5,8,7,2,2,8.5,1,1);";
		String sqln1 = "insert into nota values(2,4,7,6,1,2,7.5,1,1);";
		String sqln2 = "insert into nota values(3,7,8,8,3,2,10,1,1);";

		PreparedStatement ps18 = conexao.prepareStatement(sqln);
		PreparedStatement ps19 = conexao.prepareStatement(sqln1);
		PreparedStatement ps20 = conexao.prepareStatement(sqln2);
		ps18.execute();
		ps19.execute();
		ps20.execute();

		String sqll = "insert into login values('1111','1234');";
		String sqll1 = "insert into login values('2222','4321');";

		PreparedStatement ps21 = conexao.prepareStatement(sqll);
		PreparedStatement ps22 = conexao.prepareStatement(sqll1);

		ps21.execute();
		ps22.execute();

	}

}
