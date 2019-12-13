package model.banco;

import java.sql.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Oracle{
	private String url = "jdbc:oracle:thin:@192.168.1.29:1521:xe";
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String usuario = "usuario1";
	private String senha = "usuario123";
	
	private Connection conexao = null;
    private Statement comando = null;
	
    public boolean carregarDrive() {
		boolean sucesso = false;
		try {
			Class.forName(driver);
			sucesso = true;
		}catch (ClassNotFoundException e) {
			System.out.println("Erro:" + e.toString());
		}
		
		return sucesso;
	}
	
	public boolean conecta() {
		boolean sucesso = false;
		try {
			conexao = DriverManager.getConnection(url, usuario, senha);
			sucesso = true;
		}catch (SQLException e) {
			System.out.println("Erro:" + e.toString());
		}
		
		return sucesso;
	}

	public boolean comando() {
		boolean sucesso = false;
		try {
			comando = conexao.createStatement();
			sucesso = true;
			
		}catch (SQLException e) {
			System.out.println("Erro:" + e.toString());
		}
		
		return sucesso;
	}
	
	public ResultSet read(String sql) {
		ResultSet result = null;
		try {
			result = comando.executeQuery(sql);
		}catch (SQLException e) {
			System.out.println("Erro:" + e.toString());
		}
		
		
		return result;
	}
	
	public boolean create(String sql) {
		boolean sucesso = false;
		try {
			if(comando.executeLargeUpdate(sql) > 0) {
				conexao.commit();
				sucesso = true;
			}			
		}catch (SQLException e) {
			System.out.println("Erro:" + e.toString());
		}
		
		return sucesso;
	}
	
	public static void main() {
		Oracle o = new Oracle();
		if(o.carregarDrive() && o.conecta() && o.comando()) {
			System.out.println("Dirver Carregado com sucesso");
		}
	}

}
