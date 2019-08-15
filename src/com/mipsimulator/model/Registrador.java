package com.mipsimulator.model;

public class Registrador {

	private String nome;
	private int valor;
	
	public Registrador(String nome, int valor) {
		this.nome = nome;
		this.valor = valor;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getValor() {
		return valor;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setValor(int valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Registrador [nome=" + nome + ", valor=" + valor + "]";
	}
}
