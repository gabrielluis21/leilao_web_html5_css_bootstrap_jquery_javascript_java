package model.entidade;

import java.util.Date;

public class Usuario {
	private long codigo;
	private String nome;
	private String cpf;
	private String rg;
	private String endereco;
	private int idade;
	private Date dtNasc;
	private String email;
	
	public Usuario() {}
	
	public Usuario(long codigo, String nome, String cpf, String rg, String endereco, int idade, Date dtNasc, String email) {
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.endereco = endereco;
		this.idade = idade;
		this.dtNasc = dtNasc;
		this.email = email;
	}

	public long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getRg() {
		return rg;
	}
	
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public Date getDtNasc() {
		return dtNasc;
	}
	
	public void setDtNasc(Date dtNasc) {
		this.dtNasc = dtNasc;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
