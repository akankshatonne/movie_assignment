package com.example.assignment.service.mutation

import com.example.assignment.datasource.assignment1.entity.MovieEntity
import com.example.assignment.datasource.assignment1.repository.DirectorRepository
import com.example.assignment.datasource.assignment1.repository.MovieRepository
import org.springframework.stereotype.Service

@Service
class DirectorMutationService(private val directorRepository: DirectorRepository,
                              private val movieRepository: MovieRepository) {

    fun addDirectortoMovie(movieId: String, directorId: String): MovieEntity{

        val movie = movieRepository.getMovieById(movieId) ?: throw IllegalArgumentException("Movie with id $movieId not found")
        val director = directorRepository.getDirectorById(directorId) ?: throw IllegalArgumentException("Director with id $directorId not found")

        if(!movie.directors.contains(director)){
            movie.directors.add(director)
            director.movies.add(movie)

            movieRepository.save(movie)
            directorRepository.save(director)
        }
        else throw IllegalArgumentException("Movie already has the given director")

        return movie

    }

}