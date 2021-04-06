package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {
	
	public Map<Integer, Studente> getTuttiStudenti(){
		
		String sql = "SELECT * FROM studente";
		Map <Integer,Studente> mappaStudenti = new LinkedHashMap<Integer, Studente>();
		
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				Integer matricola = rs.getInt("matricola");
				String cognome = rs.getString("cognome");
				String nome = rs.getString("nome");
				String cds = rs.getString("CDS");
				mappaStudenti.put(matricola, new Studente(matricola, cognome, nome, cds));
				
				/*System.out.println(codins + " " + numeroCrediti + " " + nome + " " + periodoDidattico);*/
				
			}
			conn.close();
			return mappaStudenti;
			
		} catch(SQLException e) {
			throw new RuntimeException("Errore in 'getTuttiStudenti'", e);
		}
		
	}
	
	
	public List<Integer> getStudentiDelCorso(String codiceCorso){
		String sql = "SELECT matricola "
				+ "FROM iscrizione "
				+ "WHERE codins = ? ";
		
		List <Integer> listaMatricoleDelCorso = new LinkedList<Integer>();
		try {
			Connection conn = ConnectDB.getConnection();
			String codiceCorsoScelto = codiceCorso;
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, codiceCorsoScelto);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				Integer matricola = rs.getInt("matricola");
				
				//String cds = rs.getString("codins");
				listaMatricoleDelCorso.add(matricola);
			}
			conn.close();
			return listaMatricoleDelCorso;
			
		}catch(SQLException e) {
			throw new RuntimeException("Errore in 'getStudentiDelCorso'", e);
		}
		
	}
	
	

}
