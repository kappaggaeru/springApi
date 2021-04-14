package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Movie;
import com.example.demo.repository.MovieRepository;
import java.util.Optional;

import javassist.NotFoundException;
import lombok.SneakyThrows;

@Service
public class MovieServiceImpl implements MovieService{
	
	private MovieRepository movieRepository;
	
	@Autowired
	public MovieServiceImpl (MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}
	
	@Override
	public List<Movie> findAll() {
		return this.movieRepository.findAll();
	}
	
	@Override
	public void addMovie(Movie movie) {
		this.movieRepository.save(movie);
	}

	@Override
	@SneakyThrows
	public void updateMovie(Movie movie) throws Exception {
		if(this.movieRepository.findById(movie.getId()).isPresent()) {
			this.movieRepository.save(movie);
		}else {
			throw new NotFoundException("Movie does not exists");
		}
	}

	@Override
	public void deleteMovie(Integer id) throws Exception {
		Optional<Movie> movieOptional = this.movieRepository.findById(id);
		if(movieOptional.isPresent()) {
			this.movieRepository.delete(movieOptional.get());
		}else {
			throw new NotFoundException("Movie does not exists");
		}
	}

	@Override
	public Movie findById(Integer id) {
		Optional<Movie> movieOptional = this.movieRepository.findById(id);
		return movieOptional.get();
	}

	@Override
	public Movie findByTitle(String title) {
		return this.movieRepository.findByTitle(title);
	}

	@Override
	public List<Movie> findAllByYear(Integer year) {
		return this.movieRepository.findAllByYear(year);
	}
}
