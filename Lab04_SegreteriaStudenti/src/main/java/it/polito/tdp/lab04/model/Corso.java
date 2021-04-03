package it.polito.tdp.lab04.model;

public class Corso {
	
	String codice;
	int crediti;
	String nome;
	int semestre;
	
	public Corso(String codice, Integer crediti, String nome, Integer semestre) {
		super();
		this.codice = codice;
		this.crediti = crediti;
		this.nome = nome;
		this.semestre = semestre;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public int getCrediti() {
		return crediti;
	}

	public void setCrediti(int crediti) {
		this.crediti = crediti;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getSemestre() {
		return semestre;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}

	@Override
	public String toString() {
		return "Corso [codice=" + codice + ", crediti=" + crediti + ", nome=" + nome + ", semestre=" + semestre + "]";
	}
	
	
	
	

}
