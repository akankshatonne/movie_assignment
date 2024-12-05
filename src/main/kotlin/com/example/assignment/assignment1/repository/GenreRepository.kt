package com.example.assignment.datasource.assignment1.repository

import com.example.assignment.datasource.assignment1.entity.GenreEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GenreRepository: JpaRepository<GenreEntity, String> {

    fun getGenreById(id: String): GenreEntity?
}