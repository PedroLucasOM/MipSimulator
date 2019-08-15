package com.mipsimulator.model;

public class Registrador {

	private String nome;
	private int valor;
	private String endereco;
	
	public Registrador(String nome, int valor, String endereco) {
		this.nome = nome;
		this.valor = valor;
		this.endereco = endereco;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getValor() {
		return valor;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setValor(int valor) {
		this.valor = valor;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	@Override
	public String toString() {
		return "Registrador [nome=" + nome + ", valor=" + valor + ", endereco=" + endereco + "]";
	}
}
