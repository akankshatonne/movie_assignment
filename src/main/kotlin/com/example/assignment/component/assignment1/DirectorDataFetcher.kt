package com.example.assignment.component.assignment1

import com.example.assignment.codegen.DgsConstants
import com.example.assignment.datasource.assignment1.entity.DirectorEntity
import com.example.assignment.datasource.assignment1.entity.MovieEntity
import com.example.assignment.service.mutation.DirectorMutationService
import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsData
import com.netflix.graphql.dgs.InputArgument


@DgsComponent
class DirectorDataFetcher(private val directorMutationService: DirectorMutationService) {

    @DgsData(parentType = DgsConstants.Mutation_TYPE, field = DgsConstants.MUTATION.AddDirectorToMovie)
    fun addDirectorToMovie(@InputArgument(name = "movieId") movieId: String,
                           @InputArgument(name = "directorId") directorId: String): MovieEntity {
        return directorMutationService.addDirectortoMovie(movieId, directorId)
    }



}