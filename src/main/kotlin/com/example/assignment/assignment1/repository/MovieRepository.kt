package com.example.assignment.datasource.assignment1.repository

import com.example.assignment.datasource.assignment1.entity.MovieEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface MovieRepository : JpaRepository<MovieEntity, String>, JpaSpecificationExecutor<MovieEntity> {
    fun getMovieByOrderByReleaseYearDesc(): List<MovieEntity>

    fun getMovieById(id: String): MovieEntity?

    @Query("select m from MovieEntity m left join fetch m.directors where m.id in :movieIds")
    fun findAllWithMovieIds(@Param("movieIds")ids: List<String>): List<MovieEntity>



}