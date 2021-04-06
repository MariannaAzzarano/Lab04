package it.polito.tdp.lab04.DAO;

import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Studente;

public class TestDB {

	public static void main(String[] args) {

		/*
		 * 	This is a main to check the DB connection
		 */
		
		CorsoDAO cdao = new CorsoDAO();
		cdao.getTuttiICorsi();
		
		
		StudenteDAO sdao = new StudenteDAO();
		/*for(Studente stud : sdao.getTuttiStudenti().values()) {
			System.out.println("Matricola= "+stud.getMatricola()+" Cognome= "+stud.getCognome()+" Nome= "+stud.getNome()+"CDS= "+stud.getCds());
		}*/
		
		/*for(Studente stud : sdao.getStudentiDelCorso("01KSUPG").values()) {
			System.out.println("Matricola= "+stud.getMatricola()+" Cognome= "+stud.getCognome()+" Nome= "+stud.getNome()+"CDS= "+stud.getCds());
		}*/
		
		List <Integer> studenti = new LinkedList<Integer>();
		studenti = sdao.getStudentiDelCorso("01KSUPG");
		for(Integer i : studenti) {
			System.out.println(i.toString());
		}
		
	}

}
