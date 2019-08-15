package com.mipsimulator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.mipsimulator.service.RunCode;

public class MipSimulator {

	public static void main(String[] args) throws FileNotFoundException {
		FileReader arquivo = new FileReader(System.getProperty("user.dir") + "/exemplo.asm");
		BufferedReader leitor = new BufferedReader(arquivo);
		new RunCode(leitor);
	}

}
