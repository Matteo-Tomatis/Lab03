package it.polito.tdp.spellchecker;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.model.Dictionary;
import it.polito.tdp.model.RichWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class FXMLController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button button;

    @FXML
    private Button button2;

    @FXML
    private ComboBox<String> language;

    @FXML
    private TextArea txtInput;
    
    @FXML
    private TextArea txtOutput;
    
    @FXML
    private List<String> inputTextList = new ArrayList<>();
    
    @FXML 
    private Dictionary model;

    @FXML
    void doCheck(ActionEvent event) {
    	model = new Dictionary();
    	model.loadDictionary(language.getValue());
    	
    	String text = txtInput.getText().toLowerCase().replaceAll("[.,\\/#!?$%\\^&\\*;:{}=\\-_`~()\\[\\]\"]", "");
    	String[] parole = text.split(" ");
    	
    	List<String> spellCheck = new ArrayList<>();
    	for(String s : parole) {
    		spellCheck.add(s);
    	}
    	
    	List<RichWord> lista = model.spellCheckText(spellCheck);
    	
		String risultato = "";

    	for(RichWord r : lista) {
    		if(r.isControllo()==false) {
    			risultato += r.getParola() + "\n";
    		}
    	}
    	
    	this.txtOutput.clear();
    	this.txtOutput.setText(risultato);
    }

    @FXML
    void doClear(ActionEvent event) {
    	this.txtInput.clear();
    	this.txtOutput.clear();
    }

    @FXML
    void initialize() {
        assert button != null : "fx:id=\"button\" was not injected: check your FXML file 'Scene.fxml'.";
        assert button2 != null : "fx:id=\"button2\" was not injected: check your FXML file 'Scene.fxml'.";
        assert language != null : "fx:id=\"language\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtOutput != null : "fx:id=\"txtOutput\" was not injected: check your FXML file 'Scene.fxml'.";

        language.getItems().clear();
        language.getItems().add("English");
        language.getItems().add("Italiano");

    }

}
