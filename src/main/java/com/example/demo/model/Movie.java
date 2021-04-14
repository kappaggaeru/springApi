package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Movie {
	@Id
	@GeneratedValue
	private int id;
	@Column
	private String title;
	@Column
	private int year;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getId() {
		return id;
	}
	public Movie(String t, int y) {
		this.title = t;
		this.year = y;
	}
	public Movie() {};
}
