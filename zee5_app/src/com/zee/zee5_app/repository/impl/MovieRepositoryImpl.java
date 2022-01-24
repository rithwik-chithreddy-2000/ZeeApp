package com.zee.zee5_app.repository.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.zee.zee5_app.dto.Movie;
import com.zee.zee5_app.exception.IdNotFoundException;
import com.zee.zee5_app.repository.MovieRepository;

public class MovieRepositoryImpl implements MovieRepository {
	
	private Set<Movie> set = new HashSet<Movie>();
	private MovieRepositoryImpl() {
		// TODO Auto-generated constructor stub
	}
	
	private static MovieRepository movieRepository;
	public static MovieRepository getInstance() {
		if(movieRepository==null)
			movieRepository = new MovieRepositoryImpl();
		return movieRepository;
	}
	
	@Override
	public String addMovie(Movie movie) {
		// TODO Auto-generated method stub
		boolean result = this.set.add(movie);
		if(result)
			return "Success";
		return "Fail";
	}
	@Override
	public Optional<Movie> getMovieById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Movie movie2 = null;
		for (Movie movie : set) {
			if(movie.getId().equals(id)) {
				movie2 = movie;
				break;
			}
		}
		return Optional.of(Optional.ofNullable(movie2).orElseThrow(() -> new IdNotFoundException("id not found")));
	}
	@Override
	public Movie[] getAllMovies() {
		// TODO Auto-generated method stub
		Movie movie[] = new Movie[set.size()];
		return set.toArray(movie);
	}
	@Override
	public String modifyMovie(String id, Movie movie) throws IdNotFoundException {
		// TODO Auto-generated method stub
		String result = this.deleteMovie(id);
		if(result=="Failed")
			return "Failed";
		result = this.addMovie(movie);
		if(result=="Fail")
			return "Failed";
		return "Updated";
	}
	@Override
	public String deleteMovie(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Movie> optional = this.getMovieById(id);
		boolean result = set.remove(optional.get());
		if(result)
			return "Deleted";
		return "Failed";
	}

	@Override
	public List<Movie> getAllMovieDetails() {
		// TODO Auto-generated method stub
		List<Movie> arrayList = new ArrayList<Movie>(set);
		Collections.sort(arrayList);
		return arrayList;
	}

}
