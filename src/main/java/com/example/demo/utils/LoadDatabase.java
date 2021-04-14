package com.example.demo.utils;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.demo.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import com.example.demo.model.Movie;

@Configuration
@Slf4j
public class LoadDatabase {
	@Bean
    CommandLineRunner initDatabase(@Qualifier("movieRepository") MovieRepository repository) {
        return args -> {
            repository.save(new Movie("Batman",2007));
            repository.save(new Movie("Mad",1994));
        };
    }
}
