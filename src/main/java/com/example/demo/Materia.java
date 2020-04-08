package com.example.demo;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Materia {

	@Id
	@GeneratedValue
	private Long materiaId;
	private String materiaName;
	
	@ManyToMany(mappedBy = "materia")
	private Collection<Weapon> weapons;

	// default constructor
	public Materia() {
	}

	public Materia(String materiaName) {
		this.materiaName = materiaName;
	}

	public Long getId() {

		return materiaId;
	}

	public String getName() {

		return materiaName;
	}

	public Collection<Weapon> getWeapons() {
		return weapons;
	}

	public void setWeapons(Collection<Weapon> weapons) {
		this.weapons = weapons;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((materiaId == null) ? 0 : materiaId.hashCode());
		result = prime * result + ((materiaName == null) ? 0 : materiaName.hashCode());
		result = prime * result + ((weapons == null) ? 0 : weapons.hashCode());
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
		Materia other = (Materia) obj;
		if (materiaId == null) {
			if (other.materiaId != null)
				return false;
		} else if (!materiaId.equals(other.materiaId))
			return false;
		if (materiaName == null) {
			if (other.materiaName != null)
				return false;
		} else if (!materiaName.equals(other.materiaName))
			return false;
		if (weapons == null) {
			if (other.weapons != null)
				return false;
		} else if (!weapons.equals(other.weapons))
			return false;
		return true;
	}

}
