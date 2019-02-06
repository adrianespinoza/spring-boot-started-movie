package com.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
