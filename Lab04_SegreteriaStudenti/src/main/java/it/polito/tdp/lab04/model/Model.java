package it.polito.tdp.lab04.model;

import java.util.LinkedList;
//import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;

public class Model {
	
	private CorsoDAO corso;
	
	private List<Corso> listaCorsi = new LinkedList<Corso>();
	private List<String> listaNomiCorsi = new LinkedList<String>();
	
	public Model() {
		corso = new CorsoDAO();
	}

	
	
	public List<Corso> getListaCorsi(){
		
		if(this.listaCorsi.size() == 0) {
			listaCorsi.add(new Corso("",0,"",0));
			
			for(Corso c : corso.getTuttiICorsi()) {
				listaCorsi.add(c);
			}
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

}
