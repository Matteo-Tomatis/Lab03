package it.polito.tdp.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dictionary {
	
	private List<String> dizionario = new ArrayList<>();
	
	public void loadDictionary(String language) {
		dizionario.clear();
		if(language.contains("English")) {
			try {
				FileReader fr = new FileReader("src/main/resources/English.txt");
				BufferedReader br = new BufferedReader(fr);
				String word;
				while ((word = br.readLine()) != null) {
				dizionario.add(word);
				}
				br.close();
				} catch (IOException e){
				System.out.println("Errore nella lettura del file");
				}
		}
		else if(language.contains("Italiano")) {
			try {
				FileReader fr = new FileReader("src/main/resources/Italian.txt");
				BufferedReader br = new BufferedReader(fr);
				String word;
				while ((word = br.readLine()) != null) {
					dizionario.add(word);
				}
				br.close();
				} catch (IOException e){
				System.out.println("Errore nella lettura del file");
				}
		}
		else {
			System.out.println("Errore nel caricamento del dizionario");
		}
	}
	
	public List<RichWord> spellCheckText(List<String> inputTextList){
		List<RichWord> paroleControllate = new ArrayList<>();
		for(String p : inputTextList) {
			RichWord parola = new RichWord(p, false);
			paroleControllate.add(parola);
			for(String c : dizionario) {
				if (c.equals(p))
					parola.setControllo(true);
			}
		}
		
		return paroleControllate;
	}
}
