package com.example.assignment.component.assignment1

import com.example.assignment.codegen.DgsConstants
import com.example.assignment.codegen.types.AddMovieInput
import com.example.assignment.codegen.types.MovieFilterInput
import com.example.assignment.codegen.types.UpdateMovieInput
import com.example.assignment.datasource.assignment1.entity.DirectorEntity
import com.example.assignment.datasource.assignment1.entity.MovieEntity
import com.example.assignment.service.mutation.MovieMutationService
import com.example.assignment.service.query.MovieQueryService
import com.netflix.graphql.dgs.*
import org.springframework.beans.factory.annotation.Autowired
import java.util.concurrent.CompletableFuture

@DgsComponent
class MoviesDataFetcher {

    @Autowired
    private lateinit var movieMutationService: MovieMutationService

    @Autowired
    private lateinit var movieQueryService: MovieQueryService

    @DgsData(parentType = DgsConstants.QUERY_TYPE, field = DgsConstants.QUERY.AllMovies)
    fun getFilterMovies(@InputArgument(name = "filter") filter: MovieFilterInput?): List<MovieEntity> {
        return movieQueryService.getFilterMovies(filter)
    }

    @DgsData(parentType = "Movie", field = "directors")
    fun director(dfe: DgsDataFetchingEnvironment): CompletableFuture<List<DirectorEntity>>? {
        val movieId = dfe.getSource<MovieEntity>()?.id
        val dataLoader = dfe.getDataLoader<String, List<DirectorEntity>>("directorDataLoader")
        return dataLoader?.load(movieId)
    }

    @DgsData(parentType = DgsConstants.QUERY_TYPE, field = DgsConstants.QUERY.MovieById)
    fun getMovieById(@InputArgument(name = "id") movieId: String): MovieEntity? {
        return movieQueryService.getMovieById(movieId)
    }

    @DgsData(parentType = DgsConstants.Mutation_TYPE, field = DgsConstants.MUTATION.AddMovie)
    fun addMovie(@InputArgument(name = "movie") movieInput: AddMovieInput): MovieEntity {
        return movieMutationService.addMovie(movieInput)
    }

    @DgsData(parentType = DgsConstants.Mutation_TYPE, field = DgsConstants.MUTATION.UpdateMovie)
    fun updateMovie(@InputArgument(name = "id") id: String, @InputArgument(name = "movie") movieInput: UpdateMovieInput): MovieEntity {
        return movieMutationService.updateMovie(id, movieInput)
    }

    @DgsMutation
    fun deleteMovie(@InputArgument(name = "id") id: String): Boolean {
        return movieMutationService.deleteMovie(id)
    }
}