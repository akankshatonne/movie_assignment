package com.example.assignment.service.query

import com.example.assignment.codegen.types.MovieFilterInput
import com.example.assignment.datasource.assignment1.entity.MovieEntity
import com.example.assignment.datasource.assignment1.repository.MovieRepository
import com.example.assignment.datasource.assignment1.specifications.MoviezSpecifications
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MovieQueryService {

    @Autowired
    private lateinit var movieRepository: MovieRepository

    fun getFilterMovies(filter: MovieFilterInput?): List<MovieEntity>{
            filter?.let{
//                val date = Date().parseValue(filter.releasedAfter.toString())
                val spec =
                    MoviezSpecifications.buildSpec(filter.releasedYear,filter.genreId,filter.directorId,filter.releasedAfter)
                return movieRepository.findAll(spec)
                }
        return movieRepository.getMovieByOrderByReleaseYearDesc()
    }


    fun getMovieById(movieId: String): MovieEntity? {
        val result = movieRepository.getMovieById(movieId)
        return result
    }

}