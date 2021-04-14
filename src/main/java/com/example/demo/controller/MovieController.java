package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Movie;
import com.example.demo.service.MovieService;


@RestController
@RequestMapping("movies")
public class MovieController {
	
	@Autowired
	private final MovieService movieService;
	
	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}
	@GetMapping("/test")
	public String test() {
		return "working";
	}
	
	@GetMapping("/")
	public List<Movie> getMovies(){
		return this.movieService.findAll();
	}
	@GetMapping("/title/{title}")
	public Movie getMovieByTitle(@PathVariable("title") String title){
		return this.movieService.findByTitle(title);
	}
	@GetMapping("/id/{id}")
	public Movie getMovieById(@PathVariable("id") Integer id){
		return this.movieService.findById(id);
	}
	@GetMapping("/year/{year}")
	public List<Movie> getMoviesByYear(@PathVariable("year") int year){
		return this.movieService.findAllByYear(year);
	}
	@PostMapping("/")
	public ResponseEntity<?> addMovie(@RequestBody Movie m){
		this.movieService.addMovie(m);
		return ResponseEntity.status(HttpStatus.OK).body(m);
	}
	@DeleteMapping("/")
	public ResponseEntity<?> removeMovie(@RequestParam("id") int id){
		try {
			movieService.deleteMovie(id);
			return ResponseEntity.ok().body("Movie deleted with ID: "+id);
		}catch (Exception e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Movie not found");
		}
	}
	@PutMapping("/")
	public ResponseEntity<?> updateMovie(@RequestBody Movie m){
		try {
			movieService.updateMovie(m);
			return ResponseEntity.ok().body(m);
		}catch (Exception e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Movie not found");
		}
	}
}
