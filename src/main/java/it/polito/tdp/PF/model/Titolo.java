package it.polito.tdp.PF.model;

public class Titolo implements Comparable<Titolo> {
	
	private String Nome;
	private int anno;
	private double voto;
	private int durata;
	private String genere;
	private int nudita;
	private int violenza;
	private int alcool;
	private int paura;
	private String trama;
	private String Piattaforma;
	
	
	
	public String getPiattaforma() {
		return Piattaforma;
	}
	public void setPiattaforma(String piattaforma) {
		Piattaforma = piattaforma;
	}
	@Override
	public String toString() {
		return this.Nome+" ("+this.anno+")";
	}
	public Titolo(String nome, int anno, double voto, int durata, String genere, int nudita, int violenza,
			int alcool, int paura, String trama) {
		super();
		Nome = nome;
		this.anno = anno;
		this.voto = voto;
		this.durata = durata;
		this.genere = genere;
		this.nudita = nudita;
		this.violenza = violenza;
		this.alcool = alcool;
		this.paura = paura;
		this.trama = trama;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public int getAnno() {
		return anno;
	}
	public void setAnno(int anno) {
		this.anno = anno;
	}
	public double getVoto() {
		return voto;
	}
	public void setVoto(double voto) {
		this.voto = voto;
	}
	public int getDurata() {
		return durata;
	}
	public void setDurata(int durata) {
		this.durata = durata;
	}
	public String getGenere() {
		return genere;
	}
	public void setGenere(String genere) {
		this.genere = genere;
	}
	public int getNudita() {
		return nudita;
	}
	public void setNudita(int nudita) {
		this.nudita = nudita;
	}
	public int getViolenza() {
		return violenza;
	}
	public void setViolenza(int violenza) {
		this.violenza = violenza;
	}
	public int getAlcool() {
		return alcool;
	}
	public void setAlcool(int alcool) {
		this.alcool = alcool;
	}
	public int getPaura() {
		return paura;
	}
	public void setPaura(int paura) {
		this.paura = paura;
	}
	public String getTrama() {
		return trama;
	}
	public void setTrama(String trama) {
		this.trama = trama;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Nome == null) ? 0 : Nome.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Titolo other = (Titolo) obj;
		if (Nome == null) {
			if (other.Nome != null)
				return false;
		} else if (!Nome.equals(other.Nome))
			return false;
		return true;
	}
	@Override
	public int compareTo(Titolo o) {
		if(this.Nome.compareTo(o.Nome)<0) {
			return -1;
		}
		if(this.Nome.compareTo(o.Nome)>0) {
			return 1;
		}
		return 0;
	}
	
	
	
	
	
	

}
