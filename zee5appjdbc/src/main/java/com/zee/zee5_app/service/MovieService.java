package com.zee.zee5_app.service;

import java.util.List;
import java.util.Optional;

import com.zee.zee5_app.dto.Movie;
import com.zee.zee5_app.exception.IdNotFoundException;

public interface MovieService {
	
	public String addMovie(Movie movie);
	public Optional<Movie> getMovieById(String id) throws IdNotFoundException;
	public Movie[] getAllMovies();
	public String modifyMovie(String id, Movie movie) throws IdNotFoundException;
	public String deleteMovie(String id) throws IdNotFoundException;
	public List<Movie> getAllMovieDetails();

}
