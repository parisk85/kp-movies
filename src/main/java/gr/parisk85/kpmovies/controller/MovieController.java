package gr.parisk85.kpmovies.controller;

import gr.parisk85.kpmovies.model.Movie;
import gr.parisk85.kpmovies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<Optional<Movie>> getMovie(@RequestParam("id") Long id) {
        return ResponseEntity
                .ok()
                .body(movieService.getMovie(id));
    }

    @PostMapping
    public ResponseEntity createMovie(@RequestBody Movie movie) {
        URI location = ServletUriComponentsBuilder
                .fromCurrentServletMapping()
                .path("/{id}")
                .build()
                .expand(movie.getId())
                .toUri();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(location);
        movieService.createMovie(movie);
        return ResponseEntity
                .created(location)
                .body(movieService.getMovie(movie.getId()));
    }
}
