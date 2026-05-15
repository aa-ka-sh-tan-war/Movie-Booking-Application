package com.example.MovieTicket.MovieBooking.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.example.MovieTicket.MovieBooking.Exceptions.IdAlreadyExist;
import com.example.MovieTicket.MovieBooking.Exceptions.IdNotFound;
import com.example.MovieTicket.MovieBooking.Model.Movie;

import jakarta.validation.Valid;
@Service
public class MovieService implements MovieServiceInterface {
	
	
	public List<Movie> list = new ArrayList<>();
	public Map<String,Movie> movieMap = new HashMap<>();
	
	
	
	public List<Movie> getAllMovies() {
		// TODO Auto-generated method stub
		return list;
	}

	public void addmovie(@Valid Movie movie) {
		
		if (!ObjectUtils.isEmpty(movieMap.get(movie.getId()))) {
			throw new IdAlreadyExist("Already Exists");
		}
		// TODO Auto-generated method stub
		list.add(movie);
		movieMap.put(movie.getId(), movie);
	}

	public void deleteMovieById(String id) {
		// TODO Auto-generated method stub
		Movie movie = this.getMovieById(id);
		list.remove(movie);
		movieMap.remove(movie.getId());
	}

	public void updateTicket(Movie movie) {
		// TODO Auto-generated method stub
		Movie existing_movie = this.getMovieById(movie.getId());
		list.remove(existing_movie);
			movieMap.remove(existing_movie.getId());
			list.add(movie);
			movieMap.put(movie.getId(), movie);
	}

	public Movie getMovieById(String id) {
		// TODO Auto-generated method stub
		if (ObjectUtils.isEmpty(movieMap.get(id))){
			throw new IdNotFound("No ticket found with pnr : "+id);
		}
		
		return movieMap.get(id);
	}

}
