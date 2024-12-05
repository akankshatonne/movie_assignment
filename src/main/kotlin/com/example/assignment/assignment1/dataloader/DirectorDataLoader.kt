package com.example.assignment.datasource.assignment1.dataloader

import com.example.assignment.datasource.assignment1.entity.DirectorEntity
import com.example.assignment.service.query.DirectorQueryService
import com.netflix.graphql.dgs.DgsDataLoader
import org.dataloader.BatchLoader
import java.util.concurrent.CompletableFuture


@DgsDataLoader(name = "directorDataLoader")
class DirectorDataLoader(
    private val directorQueryService: DirectorQueryService): BatchLoader<String,List<DirectorEntity>> {

    override fun load(movieIds: List<String>): CompletableFuture<List<List<DirectorEntity>>>? {
        return CompletableFuture.supplyAsync {
            val directorsByMovieIds = directorQueryService.findDirectorsByMovieIds(movieIds)
            movieIds.map { directorsByMovieIds[it] ?: emptyList() }
        }
    }
}


