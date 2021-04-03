/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.lab04;


import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class FXMLController {
	
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> combo_corsi;

    @FXML
    private Button btnCercaIscritti;

    @FXML
    private TextField txtMatricola;

    @FXML
    private Button btnAuto;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtCognome;

    @FXML
    private Button btnCercaCorso;

    @FXML
    private Button btnIscrivi;

    @FXML
    private TextArea txtArea;

    @FXML
    private Button btnReset;
    
    
    @FXML
    void doReset(ActionEvent event) {
    	combo_corsi.setValue(null);
    	txtMatricola.setText("");
    	txtNome.setText("");
    	txtCognome.setText("");
    	txtArea.setText("");
    }
    
    @FXML
    void doCompleta(ActionEvent event) {
    	Integer matr = Integer.parseInt(txtMatricola.getText());
    	Studente stud = model.getMappaStudenti().get(matr);
    	txtCognome.setText(stud.getCognome());
    	txtNome.setText(stud.getNome());

    }
    

    @FXML
    void initialize() {
        assert combo_corsi != null : "fx:id=\"combo_corsi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCercaIscritti != null : "fx:id=\"btnCercaIscritti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnAuto != null : "fx:id=\"btnAuto\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCercaCorso != null : "fx:id=\"btnCercaCorso\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtArea != null : "fx:id=\"txtArea\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }


	public void setModel(Model model) {
		this.model = model;
		this.combo_corsi.getItems().addAll(this.model.getNomiCorsi());
	}
}
