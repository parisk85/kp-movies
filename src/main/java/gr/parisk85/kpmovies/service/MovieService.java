package gr.parisk85.kpmovies.service;

import gr.parisk85.kpmovies.model.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    void createMovie(Movie movie);

    List<Movie> getAllMovies();

    Optional<Movie> getMovie(Long id);
}
