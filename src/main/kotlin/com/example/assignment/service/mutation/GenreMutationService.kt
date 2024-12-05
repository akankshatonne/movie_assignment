package com.example.assignment.service.mutation

import com.example.assignment.datasource.assignment1.entity.MovieEntity
import com.example.assignment.datasource.assignment1.repository.GenreRepository
import com.example.assignment.datasource.assignment1.repository.MovieRepository
import org.springframework.stereotype.Service

@Service
class GenreMutationService(private val genreRepository: GenreRepository,
                           private val movieRepository: MovieRepository) {

    fun addGenretoMovie(movieId: String, genreId: String): MovieEntity {
        val movie = movieRepository.getMovieById(movieId) ?: throw IllegalArgumentException("Movie with id $movieId not found")
        val genre = genreRepository.getGenreById(genreId) ?: throw IllegalArgumentException("Genre with id $genreId not found")

        if(!movie.genres.contains(genre)){
            movie.genres.add(genre)
            genre.movies.add(movie)

            movieRepository.save(movie)
            genreRepository.save(genre)
        }
        else throw IllegalArgumentException("Movie already has the given genre")

        return movie

    }

}