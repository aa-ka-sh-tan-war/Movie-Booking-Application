package com.example.MovieTicket.MovieBooking.service;

import java.util.List;

import com.example.MovieTicket.MovieBooking.Model.Movie;

import jakarta.validation.Valid;

public interface MovieServiceInterface {

	void addmovie(@Valid Movie movie);

	List<Movie> getAllMovies();

	Movie getMovieById(String id);

	void deleteMovieById(String id);

	void updateTicket(Movie movie);

}
