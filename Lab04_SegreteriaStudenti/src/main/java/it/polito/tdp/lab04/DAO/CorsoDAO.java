package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;

public class CorsoDAO {
	
	/*
	 * Ottengo tutti i corsi salvati nel Db
	 */
	public List<Corso> getTuttiICorsi() {

		final String sql = "SELECT * FROM corso";

		List<Corso> corsi = new LinkedList<Corso>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				String codins = rs.getString("codins");
				int numeroCrediti = rs.getInt("crediti");
				String nome = rs.getString("nome");
				int periodoDidattico = rs.getInt("pd");

				/*System.out.println(codins + " " + numeroCrediti + " " + nome + " " + periodoDidattico);*/

				// Crea un nuovo JAVA Bean Corso
				// Aggiungi il nuovo oggetto Corso alla lista corsi
				corsi.add(new Corso(codins, numeroCrediti, nome, periodoDidattico));
			}

			conn.close();
			
			return corsi;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}
	
	
	/*
	 * Dato un codice insegnamento, ottengo il corso
	 */
	public void getCorso(Corso corso) {
		// TODO	
	}

	/*
	 * Ottengo tutti gli studenti iscritti al Corso
	 */
	public void getStudentiIscrittiAlCorso(Corso corso) {
		// TODO
	}

	/*
	 * Data una matricola ed il codice insegnamento, iscrivi lo studente al corso.
	 */
	public boolean inscriviStudenteACorso(Studente studente, Corso corso) {
		// TODO
		// ritorna true se l'iscrizione e' avvenuta con successo
		return false;
	}
	
	
	public List<String> getCorsiIscrittoStudente(Integer matricola){
		String sql = "SELECT codins "
				+ "FROM iscrizione "
				+ "WHERE matricola = ? ";
		
		List<String> listaCodiciCorsi = new LinkedList<String>();
		try {
			Connection conn = ConnectDB.getConnection();
			String matricolaScelta = ""+matricola;
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, matricolaScelta);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				String codiceCorso = rs.getString("codins");
				listaCodiciCorsi.add(codiceCorso);
			}
			
			conn.close();
			return listaCodiciCorsi;
			
		} catch (SQLException e) {
			throw new RuntimeException("Errore in 'getCorsiIscrittoStudente'", e);
		}
		
		
		
		
	}

}
