package it.polito.tdp.PF.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import it.polito.tdp.PF.db.IMDBDao;



public class Model {
public IMDBDao dao;
public List<String>generi;
	
	
	
	
	public Model() {
		dao=new IMDBDao();
		generi=dao.listAllGenres();
		
}
	
	
	public Titolo OrdinaeBest(List<Titolo>titoli){
		Collections.sort(titoli);
		double max=Integer.MIN_VALUE;
		List<Titolo>titolimigl=new ArrayList<Titolo>();
		for(Titolo t:titoli) {
			if(t.getVoto()>max) {
				max=t.getVoto();
			
			}}
			for(Titolo t2:titoli) {
				if(t2.getVoto()==max) {
					titolimigl.add(t2);
				}
			}
		
		
		
	return titolimigl.get(0);
		
		
		
	}
	
	
}