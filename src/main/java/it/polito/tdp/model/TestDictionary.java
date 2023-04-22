package it.polito.tdp.model;

import java.util.ArrayList;
import java.util.List;

public class TestDictionary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dictionary dizionario = new Dictionary();
		dizionario.loadDictionary("English");
		List<String> lista = new ArrayList<String>();
		lista.add("cat");
		lista.add("catz");
		List<RichWord> res = dizionario.spellCheckText(lista);
		for(RichWord r : res) {
			System.out.println(r.getParola());
		}
	}

}
