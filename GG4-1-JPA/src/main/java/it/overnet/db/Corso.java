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
public class Corso {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	String titolo;
	String descrizione;
	
	@Temporal(TemporalType.DATE)
	Date dataInizio;
	int durataInOre;
	
	@ManyToMany
	List<Studente> iscritti;
	
	public void addIscritto(Studente studente) {
		if (iscritti == null) {
			iscritti = new ArrayList<Studente>();
		}
		if (!iscritti.contains(studente)) {
			iscritti.add(studente);
			studente.addCorsoToPianoDiStudi(this);
		}
	}	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public Date getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}
	public int getDurataInOre() {
		return durataInOre;
	}
	public void setDurataInOre(int durataInOre) {
		this.durataInOre = durataInOre;
	}
	public List<Studente> getIscritti() {
		return iscritti;
	}
	public void setIscritti(List<Studente> iscritti) {
		this.iscritti = iscritti;
	}

}
