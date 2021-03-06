package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity

public class Victim implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="VICTIM_ID")
	private int victimId;
	@Column(name="DOG_ID")
	private int dogId;
	
	@OneToOne
	private Dog dog;
	
	@OneToMany(mappedBy="underdog")
	@JoinColumn(name="VICTIM")
	private List<Aggression> incidents = new ArrayList<Aggression>();
	
	private static final long serialVersionUID = 1L;
	
	public Victim(int victimId, int dogId) {
		super();
		this.victimId = victimId;
		this.dogId = dogId;
	}

	public Victim() {
		super();
	}

	public Dog getDog() {
		return dog;
	}

	public void setDog(Dog dog) {
		this.dog = dog;
	}

	public List<Aggression> getIncidents() {
		return incidents;
	}

	public void setIncidents(List<Aggression> incidents) {
		this.incidents = incidents;
	}

	public int getVictimId() {
		return victimId;
	}

	public void setVictimId(int victimId) {
		this.victimId = victimId;
	}

	public int getDogId() {
		return dogId;
	}

	public void setDogId(int dogId) {
		this.dogId = dogId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dogId;
		result = prime * result + victimId;
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
		Victim other = (Victim) obj;
		if (dogId != other.dogId)
			return false;
		if (victimId != other.victimId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Victim [victimId=" + victimId + ", dogId=" + dogId + "]";
	}
   
}
