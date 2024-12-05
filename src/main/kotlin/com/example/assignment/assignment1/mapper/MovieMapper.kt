package com.example.assignment.datasource.assignment1.mapper

import com.example.assignment.codegen.types.AddMovieInput
import com.example.assignment.codegen.types.MovieFilterInput
import com.example.assignment.datasource.assignment1.entity.MovieEntity
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers



interface MovieMapper {
    companion object {
        val INSTANCE: MovieMapper = Mappers.getMapper(MovieMapper::class.java)
    }
    fun createAddMovieInputToMovieEntity(addMovieInput: AddMovieInput): MovieEntity

    fun mapMovieFilterInputToMovieEntity(movieFilterInput: MovieFilterInput): MovieEntity
}
