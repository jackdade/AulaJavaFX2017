package br.edu.unoesc.revisaoOO.modelo;

import java.time.LocalDate;

public class Cliente {
	
	private String nome;
	private LocalDate DataNascimento;
	private String cpf;
	
	private Agencia agenciaPreferencial;
	
	public Cliente(){
		
	}
	
	public Cliente(String nome, LocalDate dataNascimento, String cpf) {
		super();
		this.nome = nome;
		DataNascimento = dataNascimento;
		this.cpf = cpf;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDataNascimento() {
		return DataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		DataNascimento = dataNascimento;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	//sobre escreve o método TOString do objeto,fazendo que seja impresso o nome e cpf no lugar do pacote da classe
	@Override
	public String toString(){
		return this.nome+ " "+this.cpf;
	}

	public Agencia getAgenciaPreferencial() {
		return agenciaPreferencial;
	}

	public void setAgenciaPreferencial(Agencia agenciaPreferencial) {
		this.agenciaPreferencial = agenciaPreferencial;
	}
	


	
	

}
