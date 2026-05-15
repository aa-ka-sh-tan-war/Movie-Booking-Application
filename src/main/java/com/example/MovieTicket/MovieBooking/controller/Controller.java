package com.example.MovieTicket.MovieBooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MovieTicket.MovieBooking.Exceptions.IdAlreadyExist;
import com.example.MovieTicket.MovieBooking.Model.Movie;
import com.example.MovieTicket.MovieBooking.service.MovieService;
import jakarta.validation.Valid;
@RestController
@RequestMapping("/ticket")
public class Controller {
	
	@Autowired
	private MovieService movieBookingService;
	
	@PostMapping("/movie")
	public void addTicket(@Valid @RequestBody Movie movie, BindingResult bindingResult) {
		if(bindingResult.hasErrors())
		{
			throw new RuntimeException("Request not valid");
		}
		movieBookingService.addmovie(movie);
	}
	
	@GetMapping("/movies")
	public List<Movie> getAllMovies(){
		
		return movieBookingService.getAllMovies();
	}
	
	@GetMapping("/movie/{id}")
	public Movie getMovieById(@PathVariable String id) {
		return movieBookingService.getMovieById(id);	
	}
	
	@DeleteMapping("/movie/{id}")
	public void deleteTicket(@PathVariable String id) {
		movieBookingService.deleteMovieById(id);
	}

	@PutMapping("/update/{id}")
	public void updateTicket(@RequestBody Movie movie) {
		movieBookingService.updateTicket(movie);
	}
}
