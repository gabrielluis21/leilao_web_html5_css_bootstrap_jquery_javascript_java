package model.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.banco.Oracle;
import model.entidade.Usuario;


public class DaoUsuario {
	
	private Oracle oracle;
	
	public boolean create(Usuario user) {
		boolean sucesso = false;
		String sql = "INSERT INTO usuario";
		sql += "("+user.getCodigo() + ",'" +user.getNome() +"','"+user.getCpf()+"',";
		sql += "'"+user.getRg()+"',"+user.getIdade()+",'"+user.getEndereco()+"',"+user.getDtNasc()+")";
		
		this.oracle = new Oracle();
		
		if(this.oracle.carregarDrive() && this.oracle.conecta() && this.oracle.comando() && this.oracle.create(sql)) {
			sucesso = true;
		}
		
		return sucesso;
	}
	
	
	public boolean update(Usuario user) {
		boolean sucesso = false;
		String sql = "UPDATE produto";
		sql += "SET codigo ="+user.getCodigo() + ", nome = '" +user.getNome() +"', cpf ="+user.getCpf()+",";
		sql += "rg = "+user.getRg()+", idade ="+user.getIdade()+", endereco ="+user.getEndereco()+", dtNasc ="+user.getDtNasc();
		sql += "WHERE codigo = "+user.getCodigo();
		
		this.oracle = new Oracle();
		
		if(this.oracle.carregarDrive() && this.oracle.conecta() && this.oracle.comando() && this.oracle.create(sql)) {
			sucesso = true;
		}
		
		return sucesso;
	}


	public Usuario GetOne(Usuario usuario) {
		String sql = "SELECT * FROM usuario";
		sql += "WHERE codigo = "+usuario.getCodigo();
		ResultSet result;
		
		this.oracle = new Oracle();
		
		if(this.oracle.carregarDrive() && this.oracle.conecta() && this.oracle.comando()) {
			result = this.oracle.read(sql);
			if(result != null) {
				try {
					usuario.setNome(result.getString("nome"));
					usuario.setIdade(result.getInt("idade"));
					usuario.setCpf(result.getString("cpf"));
					usuario.setRg(result.getString("rg"));
					usuario.setEmail(result.getString("email"));
					usuario.setEndereco(result.getString("endereco"));
					usuario.setDtNasc(result.getDate("DtNasc"));
				}catch (SQLException e) {
					// TODO: handle exception
				}
			}else {
				usuario = null;
			}
		}
		return usuario;
	}
	
	@SuppressWarnings("null")
	public List<Usuario> getAll(){
		List<Usuario> userList = null; 
		Usuario usuario = new Usuario();
		String sql = "SELECT * FROM usuario";
		ResultSet result;
		
		this.oracle = new Oracle();
		try {
			if(this.oracle.carregarDrive() && this.oracle.conecta() && this.oracle.comando()) {
				result = this.oracle.read(sql);
				if (result != null) {
					while(result.next()) {
						usuario.setNome(result.getString("nome"));
						usuario.setIdade(result.getInt("idade"));
						usuario.setCpf(result.getString("cpf"));
						usuario.setRg(result.getString("rg"));
						usuario.setEmail(result.getString("email"));
						usuario.setEndereco(result.getString("endereco"));
						usuario.setDtNasc(result.getDate("DtNasc"));
						userList.add(usuario);
					}
				}
			}
		}catch (SQLException e) {
			// TODO: handle exception
		}
		
		return userList;
	}
	
	@SuppressWarnings("null")
	public Usuario GetOneByLogin(String email, String senha) {
		String sql = "SELECT * FROM usuario";
		sql += "WHERE emial = '"+email+"' AND senha = '"+senha+"'";
		ResultSet result;
		Usuario usuario = null;
		this.oracle = new Oracle();
		
		if(this.oracle.carregarDrive() && this.oracle.conecta() && this.oracle.comando()) {
			result = this.oracle.read(sql);
			if(result != null) {
				try {
					usuario.setNome(result.getString("nome"));
					usuario.setIdade(result.getInt("idade"));
					usuario.setCpf(result.getString("cpf"));
					usuario.setRg(result.getString("rg"));
					usuario.setEmail(result.getString("email"));
					usuario.setEndereco(result.getString("endereco"));
					usuario.setDtNasc(result.getDate("DtNasc"));
				}catch (SQLException e) {
					// TODO: handle exception
				}
			}else {
				usuario = null;
			}
		}
		return usuario;
	}
}
