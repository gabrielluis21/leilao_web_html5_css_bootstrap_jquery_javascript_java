package model.entidade;

import java.util.Date;

public class Lance {
	private long codigo;
	private double valor;
	private Date dtLance;
	private Usuario usuario;
	
	public Lance() {}
	
	public Lance(long codigo, double valor, Date dtLance, Usuario usuario) {
		this.codigo = codigo;
		this.valor = valor;
		this.dtLance = dtLance;
		this.usuario = usuario;
	}
	
	public long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public Date getDtLance() {
		return dtLance;
	}
	
	public void setDtLance(Date dtLance) {
		this.dtLance = dtLance;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
