package com.example.assignment.service.mutation

import com.example.assignment.codegen.types.AddMovieInput
import com.example.assignment.codegen.types.UpdateMovieInput
import com.example.assignment.datasource.assignment1.entity.MovieEntity
import com.example.assignment.datasource.assignment1.mapper.MovieMapper
import com.example.assignment.datasource.assignment1.repository.MovieRepository
import com.example.assignment.datasource.assignment1.util.GraphQLBeanMapper

import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
@Transactional
class MovieMutationService(private val movieRepository: MovieRepository) {

    fun addMovie(movieInput: AddMovieInput): MovieEntity {
        val movieEntity = GraphQLBeanMapper.mapAddMovieInputToMovieEntity(movieInput)
//        val movieEntity = MovieMapper.INSTANCE.createAddMovieInputToMovieEntity(movieInput)
        return movieRepository.save(movieEntity)
    }

    fun updateMovie(id: String, movieInput: UpdateMovieInput): MovieEntity {
        val movie = movieRepository.getMovieById(id)
        movie?.let {
            movieInput.title?.let {
                movie.title = movieInput.title
            }
            movieInput.releaseYear?.let {
                movie.releaseYear = movieInput.releaseYear
            }
            return movieRepository.save(movie)
        }
        throw IllegalArgumentException("Movie with id $id not found")
    }


    fun deleteMovie(id: String): Boolean {
        val movie = movieRepository.getMovieById(id)
        movie?.let {
            movie.directors.forEach {it.movies.remove(movie)}
            movie.genres.forEach {it.movies.remove(movie)}
            movieRepository.deleteById(id)
            return true
        }
        return false
    }

}