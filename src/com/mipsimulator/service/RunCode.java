package com.mipsimulator.service;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.mipsimulator.model.Endereco;
import com.mipsimulator.model.Registrador;

public class RunCode {
	
	private List<String> codigo = new ArrayList<String>();
	private List<Registrador> registradores = new ArrayList<Registrador>();
	private List<Endereco> RAM = new ArrayList<Endereco>();
	private String operador;
	private String[] instrucao;

	public RunCode(BufferedReader leitor) {
		leitor.lines().forEach(linha -> this.codigo.add(linha));
		run();
	}
	
	public void run() {
		for(int i=0; i < this.codigo.size(); i++){
			String[] linhaFormatada = codigo.get(i).split(" ");
			
			if(linhaFormatada[0].contains(":")) {
				if(linhaFormatada.length == 1) {
					this.operador = linhaFormatada[0];
				}else {
					this.operador = linhaFormatada[1];
					this.instrucao = linhaFormatada[2].split(",");					
				}
			}else {
				this.operador = linhaFormatada[0];
				this.instrucao = linhaFormatada[1].split(",");
			}
			
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
				registrador6.setValor(buscarNaMemoria(registrador7));
				break;
			case "beq":
				Registrador registrador8 = VerificaSeExiste(this.instrucao[0]);
				Registrador registrador9 = VerificaSeExiste(this.instrucao[1]);
				String label = this.instrucao[2];
				if(registrador8.getValor() == registrador9.getValor()) {
					i = buscarLinhaLabel(label, codigo.get(i));
				}
				break;
			case "j":
				String labelJump = this.instrucao[0];
				i = buscarLinhaLabel(labelJump, codigo.get(i));
				break;
			case "sw":
				Registrador registrador10 = VerificaSeExiste(this.instrucao[0]);
				Registrador registrador11 = VerificaSeExiste(this.instrucao[1].replace("0(", "").replace(")", ""));
				salvarNaMemoria(registrador10, registrador11);
				break;
			default:
				break;
			}
		}
		System.out.println("Registradores:");
		this.registradores.forEach(registrador -> System.out.println(registrador));
		System.out.println();
		System.out.println("Memória:");
		this.RAM.forEach(endereco -> System.out.println(endereco));
	}

	private Registrador VerificaSeExiste(String nomeRegistrador) {	
		for(Registrador registrador : this.registradores) {
			if(registrador.getNome().equals(nomeRegistrador)) {
				return registrador;
			}
		}
		Registrador novoRegistrador = new Registrador(nomeRegistrador, 0, UUID.randomUUID().toString());
		this.registradores.add(novoRegistrador);
		return novoRegistrador;
	}
		
	private int buscarLinhaLabel(String label, String linhaAtual) {
		for(String linha : this.codigo) {
			if(linha.contains(label) && !linha.equals(linhaAtual)) {
				return this.codigo.indexOf(linha) - 1;
			}
		}
		return -1;
	}
	
	private int buscarNaMemoria(Registrador registrador7) {
		for(Endereco endereco : this.RAM) {
			if(endereco.getEndereco().equals(registrador7.getValor() + "")) {
				return endereco.getValor();
			}
		}
		return 0;
	}
	
	private int salvarNaMemoria(Registrador registrador10, Registrador registrador11) {
		for(Endereco endereco : this.RAM) {
			if(endereco.getEndereco().equals(registrador11.getValor() + "")) {
				endereco.setValor(registrador10.getValor());
				return 0;
			}
		}
		this.RAM.add(new Endereco(registrador11.getValor() + "", registrador10.getValor()));
		return 0;
	}
}
