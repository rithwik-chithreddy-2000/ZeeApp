package com.zee.zee5app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.service.MovieService;

@SpringBootApplication
public class TestMovieApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext =
				SpringApplication.run(TestMovieApplication.class, args);
		
		MovieService movieService = applicationContext.getBean(MovieService.class);
		System.out.println("Add Movie");
		for (int i = 1; i <= 5; i++) {
			Movie movie = new Movie("mov000"+i, "MovieName"+i, 5+i, "Cast"+i, "Genre"+i, 120+i, "Link"+i, "2022-04-0"+i, "Language"+i);
			System.out.println(movieService.addMovie(movie) + " " + i);
		}
		System.out.println();
		
		System.out.println("Get Movie by Id");
		System.out.println(movieService.getMovieById("mov0004").get());
		System.out.println();
		
		System.out.println("Get All Movie Details - List");
		movieService.getAllMovieDetails().get().forEach(e->System.out.println(e));
		System.out.println();
		
		System.out.println("Delete Movie by Id");
		try {
			System.out.println(movieService.deleteMovie("mov0003"));
		} catch (IdNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println();
		
		System.out.println("Get All Movie Details - Array");
		for (Movie movie : movieService.getAllMovies()) {
			System.out.println(movie);
		}
		System.out.println();
		
		applicationContext.close();
	}

}
