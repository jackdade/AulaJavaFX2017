package br.edu.unoesc.revisaoOO.modelo;

import java.io.Serializable;

public class Agencia implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1320599973517592837L;
	private String nome;
	private String numero;
	
	public Agencia(){
		
	}
	
	public Agencia(String nome, String numero){
		super();
		this.nome = nome;
		this.numero = numero;
		
	}
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
	@Override
	public String toString(){
		return this.nome + " " +this.numero;
	}
	

}
