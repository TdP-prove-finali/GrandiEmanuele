package it.polito.tdp.PF.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;

import org.jgrapht.graph.SimpleGraph;

import it.polito.tdp.PF.db.IMDBDao;







public class Model {
public IMDBDao dao;
public List<String>generi;
public Graph<Titolo,DefaultEdge>grafo;

public List<Titolo>finale;

private List<Titolo>connesse;
public List<Titolo>titolipiatt;
	
	
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
	
	
	
	public void CreaGrafo(String genere,double nud,double viol,double alc,double fri,List<String>piattaforme,double vot,int duratatot,int anno1,int anno2) {
		this.grafo=new SimpleGraph<>(DefaultEdge.class);
		List<Titolo>titolicompl=new ArrayList<Titolo>();
		
		titolicompl=dao.getVertici(genere, nud, viol, alc, fri,vot,anno1,anno2);
		titolipiatt=new ArrayList<Titolo>();
	
	
	for(Titolo t:titolicompl) {
		if(piattaforme.contains(t.getPiattaforma())&& t.getDurata()<=duratatot) {
			titolipiatt.add(t);
		}
	}
	
	Graphs.addAllVertices(grafo, titolipiatt);
	
	for(Titolo t1:titolipiatt) {
		for(Titolo t2: titolipiatt) {
			if(!t1.equals(t2)) {
				Graphs.addEdgeWithVertices(grafo, t1, t2);
			}
		}
	}
	}
	
	
	 public List<Titolo> CreaCammino(int duratatot){
		
		 finale =new ArrayList<Titolo>() ;
		 List<Titolo>parziale=new ArrayList<>();
		
		
		
		if (titolipiatt.size()==0) {
			return null;
		}
		int indice=(int)(Math.random()*titolipiatt.size());
		
		Titolo Part=titolipiatt.get(indice);
		
			
		connesse=new LinkedList<Titolo>(Graphs.neighborListOf(this.grafo,Part));
		 
		 parziale.add(Part);
			cerca(parziale,duratatot,connesse);
			
			return finale;
			
			
			
			
			
			
		}


	private void cerca(List<Titolo> parziale, int duratatot, List<Titolo>connesse) {
		
		int tottitoli=parziale.size();
		if(tottitoli>finale.size()|| finale==null) {
			finale=new ArrayList<>(parziale);
		}
		
		for(Titolo t:connesse) {
			if(!parziale.contains(t)) {
				parziale.add(t);
				
				if(aggiuntavalida(parziale,duratatot,t)) {
					cerca(parziale,duratatot,connesse);
				}
				parziale.remove(t);
			}
			
		}
	}


	private boolean aggiuntavalida(List<Titolo> parziale, int duratatot, Titolo t) {
		int durata_att=this.calcolopeso(parziale)+t.getDurata();
		if(durata_att<=duratatot) {
			return true;
		}
			return false;
		
		
	}
	
	public int calcolopeso(List<Titolo>lista) {
		int durata=0;
		for(Titolo t: lista) {
			durata+=t.getDurata();
		}
		return durata;
	}
	
	
	public double  calcolaValMedia(List<Titolo>parziale) {
		double somma=0.0;
		int tot=parziale.size();
		
		for(Titolo t:parziale) {
			somma+=t.getVoto();
		}
		
		double media=(double)(somma/tot);
		
		return media;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
