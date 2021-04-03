package it.polito.tdp.lab04.DAO;

import it.polito.tdp.lab04.model.Studente;

public class TestDB {

	public static void main(String[] args) {

		/*
		 * 	This is a main to check the DB connection
		 */
		
		CorsoDAO cdao = new CorsoDAO();
		cdao.getTuttiICorsi();
		
		
		StudenteDAO sdao = new StudenteDAO();
		for(Studente stud : sdao.getTuttiStudenti().values()) {
			System.out.println("Matricola= "+stud.getMatricola()+" Cognome= "+stud.getCognome()+" Nome= "+stud.getNome()+"CDS= "+stud.getCds());
		}
		
		
	}

}
