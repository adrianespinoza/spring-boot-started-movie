package com.movie.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.movie.model.Movie;
import com.movie.repository.MovieRepository;

@RestController
@RequestMapping("api/v1/")
public class MovieController {
	
	@Autowired
	private MovieRepository movieRepository;
	
	@RequestMapping(value = "movies", method = RequestMethod.GET)
	public List<Movie> list() {
		return movieRepository.findAll();
	}
	
	@RequestMapping(value = "movies", method = RequestMethod.POST)
	public Movie create(@RequestBody Movie movie) {
		return movieRepository.saveAndFlush(movie);
	}
	
	@RequestMapping(value = "movies/{id}", method = RequestMethod.GET)
	public Movie get(@PathVariable Long id) {
		return movieRepository.findOne(id);
	}
	
	@RequestMapping(value = "movies/{id}", method = RequestMethod.PUT)
	public Movie put(@PathVariable Long id, @RequestBody Movie movie) {
		Movie existingMovie = movieRepository.findOne(id);
		BeanUtils.copyProperties(movie, existingMovie);
		return movieRepository.saveAndFlush(movie);
	}

	@RequestMapping(value = "movies/{id}", method = RequestMethod.DELETE)
	public Movie put(@PathVariable Long id) {
		Movie existingMovie = movieRepository.findOne(id);
		movieRepository.delete(existingMovie);
		return existingMovie;
	}
}
