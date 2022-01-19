package com.zee.zee5_app.repository;

import com.zee.zee5_app.dto.Movie;

public class MovieRepository {
	
	private Movie[] movies = new Movie[10];
	private static int movieCount = -1;
	private MovieRepository() {
		// TODO Auto-generated constructor stub
	}
	
	public String addMovie(Movie movie) {
		if(movieCount==movies.length-1) {
			Movie temp[] = new Movie[movies.length*2];
			System.arraycopy(movies, 0, temp, 0, movies.length);
			movies = temp;
		}
		movies[++movieCount] = movie;
		return "Success";
	}
	
	public Movie getMovieById(String id) {
		for (Movie movie : movies) {
			if(movie!=null && movie.getId().equals(id))
				return movie;
		}
		return null;
	}
	
	public Movie[] getAllMovies() {
		return movies;
	}
	
	public String modifyMovie(String id, Movie movie) {
		for (int i = 0; i < movies.length; i++) {
			if(movies[i].getId().equals(id)) {
				movies[i] = movie;
				return "Modified";
			}
		}
		return "Id does not exist";
	}
	
	public String deleteMovie(String id) {
		for (int i = 0; i < movies.length; i++) {
			if(movies[i].getId().equals(id)) {
				System.arraycopy(movies, i+1, movies, i, movieCount-i);
				movies[movieCount--] = null;
				return "Deleted";
			}
		}
		return "Id does not exist";
	}
	
	private static MovieRepository movieRepository;
	public static MovieRepository getInstance() {
		if(movieRepository==null)
			movieRepository = new MovieRepository();
		return movieRepository;
	}

}
