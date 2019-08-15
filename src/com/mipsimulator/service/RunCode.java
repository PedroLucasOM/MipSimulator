package com.mipsimulator.service;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

import com.mipsimulator.model.Registrador;

public class RunCode {
	
	private List<String> codigo = new ArrayList<String>();
	private List<Registrador> registradores = new ArrayList<Registrador>();
	private String operador;
	private String[] instrucao;

	public RunCode(BufferedReader leitor) {
		leitor.lines().forEach(linha -> this.codigo.add(linha));
		run();
	}
	
	public void run() {
		for(int i=0; i < this.codigo.size(); i++){
			String[] linhaFormatada = codigo.get(i).split(" ");
			this.operador = linhaFormatada[0];
			this.instrucao = linhaFormatada[1].split(",");
			switch (this.operador) {
			case "addi":
				Registrador registrador1 = VerificaSeExiste(this.instrucao[0]);
				Registrador registrador2 = VerificaSeExiste(this.instrucao[1]);
				int valor = Integer.parseInt(this.instrucao[2]);
				registrador1.setValor(registrador2.getValor()+valor);
				break;
			case "add":
				Registrador registrador3 = VerificaSeExiste(this.instrucao[0]);
				Registrador registrador4 = VerificaSeExiste(this.instrucao[1]);
				Registrador registrador5 = VerificaSeExiste(this.instrucao[2]);
				registrador3.setValor(registrador4.getValor() + registrador5.getValor());
				break;
			case "lw":
				Registrador registrador6 = VerificaSeExiste(this.instrucao[0]);
				Registrador registrador7 = VerificaSeExiste(this.instrucao[1].replace("0(", "").replace(")", ""));
				registrador6.setValor(registrador7.getValor());
				break;
			case "beq":
				Registrador registrador8 = VerificaSeExiste(this.instrucao[0]);
				Registrador registrador9 = VerificaSeExiste(this.instrucao[1]);
				String label = this.instrucao[2];
				if(registrador8.getValor() == registrador9.getValor()) {
					i = buscarLinhaLabel(label);
				}
			default:
				break;
			}
		}
		this.registradores.forEach(registrador -> System.out.println(registrador));
	}


	private Registrador VerificaSeExiste(String nomeRegistrador) {	
		for(Registrador registrador : this.registradores) {
			if(registrador.getNome().equals(nomeRegistrador)) {
				return registrador;
			}
		}
		Registrador novoRegistrador = new Registrador(nomeRegistrador, 0);
		this.registradores.add(novoRegistrador);
		return novoRegistrador;
	}
		
	private int buscarLinhaLabel(String label) {
		for(String linha : this.codigo) {
			if(linha.equals(label)) {
				return this.codigo.indexOf(linha);
			}
		}
		return -1;
	}
	
}
