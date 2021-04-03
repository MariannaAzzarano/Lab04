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

}
