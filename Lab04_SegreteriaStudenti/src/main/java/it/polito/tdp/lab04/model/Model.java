package it.polito.tdp.lab04.model;

import java.util.LinkedHashMap;
import java.util.LinkedList;
//import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {
	
	private CorsoDAO corso;
	private StudenteDAO studente;
	
	private List<Corso> listaCorsi = new LinkedList<Corso>();
	private List<String> listaNomiCorsi = new LinkedList<String>();
	private Map<Integer, Studente> mappaStudenti = new LinkedHashMap<Integer, Studente>();
	private Map<String, Corso> mappaCorsi = new LinkedHashMap<String, Corso>();
	
	
	public Model() {
		corso = new CorsoDAO();
		studente = new StudenteDAO();
	}

	
	
	public List<Corso> getListaCorsi(){
		if(this.listaCorsi.size() == 0) {
			for(Corso c : corso.getTuttiICorsi()) {
				listaCorsi.add(c);
			}
			listaCorsi.add(new Corso("",0,"",0));
		}
		return listaCorsi;
	}
	
	public Map<String, Corso> getMappaCorsi(){
		if(mappaCorsi.size() == 0) {
			for(Corso cc : corso.getTuttiICorsi()) {
				mappaCorsi.put(cc.getCodice(), cc);
			}
		}
		return mappaCorsi;
	}
	
	
	public List<String> getNomiCorsi(){
		if(this.getListaCorsi() != null) {
			for(Corso c : this.getListaCorsi()) {
				listaNomiCorsi.add(c.getNome());
			}
		}
		return listaNomiCorsi;
	}
	
	public Map<Integer, Studente> getMappaStudenti(){
		if(mappaStudenti.size() == 0) {
			for(Studente st : studente.getTuttiStudenti().values()) {
				mappaStudenti.put(st.getMatricola(), st);
			}
		}
		return mappaStudenti;
	}
	
	public List<Studente> getListaStudentiDelCorso(String nomeCorso){
		List <Studente> listaStudentiDelCorso = new LinkedList<Studente>();
		List <Integer> listaMatricole = new LinkedList <Integer>();
		String codiceCorso = "";
		for(Corso cors : this.getListaCorsi()) {
			if(nomeCorso.equals(cors.getNome())) {
				codiceCorso = cors.getCodice();
			}
		}
		//prima di fare questo devo trovare il codice del corso avendo il nome 
		listaMatricole = studente.getStudentiDelCorso(codiceCorso);
		for(Integer m : listaMatricole) {
			listaStudentiDelCorso.add(this.getMappaStudenti().get(m));
		}
		return listaStudentiDelCorso;
	}
	
	public List<Corso> getListaCorsiDelloStudente(Integer matricola){
		List<Corso> listaCorsiStudente = new LinkedList<Corso>();
		//List<Corso> listaCorsi = this.getListaCorsi();
		for(String codice : corso.getCorsiIscrittoStudente(matricola)) {
			Corso cc = this.getMappaCorsi().get(codice);
			listaCorsiStudente.add(cc);
		}
		
		
		return listaCorsiStudente;
	}
	
	public boolean studenteEsistente(Integer matricola) {
		if(this.getMappaStudenti().containsKey(matricola)) {
			return true;
		}
		return false;
	}

}
