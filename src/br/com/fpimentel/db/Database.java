package br.com.fpimentel.db;

public class Database {

	/* Conex�o com SQL */
	// -- Ambiente do SJT (Produ��o)
	//protected static String url = "jdbc:sqlserver://192.168.100.204:49996;databaseName=SAOJUDAS_JAVA";
	//protected static String userDB = "sa";
	//protected static String passDB = "#abc123#";
	// -- Ambiente Local (Testes de Novas Funcionalidades)
	protected static String url = "jdbc:sqlserver://localhost;databaseName=ProgramaJava";
	protected static String userDB = "sa";
	protected static String passDB = "java";

}