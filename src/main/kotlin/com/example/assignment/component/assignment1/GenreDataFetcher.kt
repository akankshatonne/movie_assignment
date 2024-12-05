package com.example.assignment.component.assignment1

import com.example.assignment.codegen.DgsConstants
import com.example.assignment.codegen.types.Genre
import com.example.assignment.datasource.assignment1.entity.MovieEntity
import com.example.assignment.service.mutation.GenreMutationService
import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsData
import com.netflix.graphql.dgs.DgsMutation
import com.netflix.graphql.dgs.InputArgument

@DgsComponent
class GenreDataFetcher(private val genreMutationService: GenreMutationService) {

    @DgsMutation
    fun addGenreToMovie(@InputArgument(name = "movieId") movieId: String,
                        @InputArgument(name = "genreId") directorId: String): MovieEntity {
        return genreMutationService.addGenretoMovie(movieId, directorId)
    }

}