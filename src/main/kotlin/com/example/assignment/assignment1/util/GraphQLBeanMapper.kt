package com.example.assignment.datasource.assignment1.util

import com.example.assignment.codegen.types.AddMovieInput
import com.example.assignment.datasource.assignment1.entity.MovieEntity
import org.springframework.context.annotation.Configuration

@Configuration
class GraphQLBeanMapper {

    companion object {
        fun mapAddMovieInputToMovieEntity(addMovieInput: AddMovieInput): MovieEntity {
            val movieEntity = MovieEntity()
            movieEntity.title = addMovieInput.title
            movieEntity.releaseYear = addMovieInput.releaseYear
//            movieEntity.releaseDate = addMovieInput.releaseDate
            return movieEntity
        }

    }

}