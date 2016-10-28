package it.overnet.db;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Studente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	String nome;
	String cognome;
	
	@Temporal(TemporalType.DATE)
	Date dataNascita;
	
	int altezzaInCm;
	float pesoInKg;
	int matricola;
	
	@ManyToMany(mappedBy="iscritti")
	List<Corso> pianoDiStudi;
	
	public void addCorsoToPianoDiStudi(Corso c) {
		if (pianoDiStudi == null) {
			pianoDiStudi = new ArrayList<Corso>();
		}
		if (!pianoDiStudi.contains(c)) {
			pianoDiStudi.add(c);
			c.addIscritto(this);
		}
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public Date getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}
	public int getAltezzaInCm() {
		return altezzaInCm;
	}
	public void setAltezzaInCm(int aletzzaInCm) {
		this.altezzaInCm = aletzzaInCm;
	}
	public float getPesoInKg() {
		return pesoInKg;
	}
	public void setPesoInKg(float pesoInKg) {
		this.pesoInKg = pesoInKg;
	}
	public int getMatricola() {
		return matricola;
	}
	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}
	public List<Corso> getPianoDiStudi() {
		return pianoDiStudi;
	}
	public void setPianoDiStudi(List<Corso> pianoDiStudi) {
		this.pianoDiStudi = pianoDiStudi;
	}
	
	
}
