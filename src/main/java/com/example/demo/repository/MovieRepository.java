package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer>{
	@Query("SELECT p FROM Movie p WHERE p.year = :year")
	public List<Movie> findAllByYear(int year);
	
	@Query("SELECT p FROM Movie p WHERE p.title = :title")
	public Movie findByTitle(String title);
}