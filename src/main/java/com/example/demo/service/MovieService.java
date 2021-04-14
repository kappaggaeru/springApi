package com.example.demo.service;

import java.util.List;
import com.example.demo.model.Movie;

public interface MovieService {
	List<Movie> findAll();
	List<Movie> findAllByYear(Integer year);
	
	Movie findByTitle(String title);
	Movie findById(Integer id);
	
	void addMovie(Movie movie);
	void updateMovie(Movie movie) throws Exception;
	void deleteMovie(Integer id) throws Exception;
}
