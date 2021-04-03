package it.polito.tdp.lab04.model;

import java.util.LinkedList;
import java.util.List;

public class TestModel {

	public static void main(String[] args) {

		Model model = new Model();
		
		/*
		 * 	Write here your test model
		 */
		
		
		/*for(Corso c : model.getListaCorsi()) {
			System.out.println(c.toString());
		}*/
		
		Studente s = model.getMappaStudenti().get(146101);
		System.out.println("COGNOME= " +s.getCognome()+" NOME= "+s.getNome());
		

	}

}
