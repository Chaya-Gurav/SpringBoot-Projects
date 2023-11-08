package com.springboot.movieticktes.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String movie;
	
	private String screen;
	
	private String seat;
	
	public Ticket() {
		
	}

	public Ticket(String movie, String screen, String seat) {
		super();
		this.movie = movie;
		this.screen = screen;
		this.seat = seat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMovie() {
		return movie;
	}

	public void setMovie(String movie) {
		this.movie = movie;
	}

	public String getScreen() {
		return screen;
	}

	public void setScreen(String screen) {
		this.screen = screen;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}
	
	
	
}
