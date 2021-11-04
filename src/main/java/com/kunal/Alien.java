package com.kunal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Alien {
	
	@Id
	private int id;
	private String name;
	private int points;
	
	public Alien(int id, String name, int points) {
		this.id = id;
		this.name = name;
		this.points = points;
	}
	
	public Alien() {
		super();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String toString() {
		return "{ id: " + this.id + ", name: " + this.name + ", points: " + this.points + " }";
	}

}
