package com.mipsimulator.model;

public class Endereco {

	private String endereco;
	private int valor;
	
	public Endereco(String endereco, int valor) {
		this.endereco = endereco;
		this.valor = valor;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public int getValor() {
		return valor;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public void setValor(int valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Endereco [endereco=" + endereco + ", valor=" + valor + "]";
	}
}
