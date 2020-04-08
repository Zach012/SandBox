package com.example.demo;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Weapon {

	@Id
	@GeneratedValue
	private Long weaponId;
	private String weaponName;

	@ManyToMany
	@JoinTable(name = "weap_mat", joinColumns = @JoinColumn(name = "weapon_id"), inverseJoinColumns = @JoinColumn(name = "materia_id"))
	private Collection<Materia> materia;

//	default constructor
	public Weapon() {
	}

	public Weapon(String weaponName, Materia... materia) {
		this.weaponName = weaponName;
		this.materia = new HashSet<>();
	}

	public Long getId() {

		return weaponId;
	}

	public String getName() {

		return weaponName;
	}

	public Collection<Materia> getMateria() {

		return materia;
	}

	public void setMateria(Collection<Materia> materia) {
		this.materia = materia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((materia == null) ? 0 : materia.hashCode());
		result = prime * result + ((weaponId == null) ? 0 : weaponId.hashCode());
		result = prime * result + ((weaponName == null) ? 0 : weaponName.hashCode());
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
		Weapon other = (Weapon) obj;
		if (materia == null) {
			if (other.materia != null)
				return false;
		} else if (!materia.equals(other.materia))
			return false;
		if (weaponId == null) {
			if (other.weaponId != null)
				return false;
		} else if (!weaponId.equals(other.weaponId))
			return false;
		if (weaponName == null) {
			if (other.weaponName != null)
				return false;
		} else if (!weaponName.equals(other.weaponName))
			return false;
		return true;
	}

}