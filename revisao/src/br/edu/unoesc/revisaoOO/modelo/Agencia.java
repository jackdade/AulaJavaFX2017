package br.edu.unoesc.revisaoOO.modelo;

import java.io.Serializable;

import br.edu.unoesc.revisaoOO.componente.RenderizaCombo;

public class Agencia implements Serializable ,RenderizaCombo{
	
	
	
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

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return this.nome;
	}
	

}
