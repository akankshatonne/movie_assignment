package com.example.assignment.service.query

import com.example.assignment.datasource.assignment1.entity.DirectorEntity
import com.example.assignment.datasource.assignment1.repository.DirectorRepository
import com.example.assignment.datasource.assignment1.repository.MovieRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class DirectorQueryService(private val directorRepository: DirectorRepository,
                            private val movieRepository: MovieRepository
) {

//    @Transactional
    fun findDirectorsByMovieIds(movieIds: List<String>): Map<String, List<DirectorEntity>> {
        val movies = movieRepository.findAllWithMovieIds(movieIds)
        return movies.associate { it.id to it.directors.toList() }
    }
}