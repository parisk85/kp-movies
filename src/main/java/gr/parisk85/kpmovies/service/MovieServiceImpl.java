package gr.parisk85.kpmovies.service;

import gr.parisk85.kpmovies.model.Movie;
import gr.parisk85.kpmovies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public void createMovie(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public List<Movie> getAllMovies() {
        return null;
    }

    @Override
    public Optional<Movie> getMovie(Long id) {
        return movieRepository.findById(id);
    }
}
