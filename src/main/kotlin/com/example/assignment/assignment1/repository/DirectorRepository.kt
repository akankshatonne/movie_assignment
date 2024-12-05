package com.example.assignment.datasource.assignment1.repository

import com.example.assignment.datasource.assignment1.entity.DirectorEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DirectorRepository: JpaRepository<DirectorEntity, String> {

    fun getDirectorById(id: String): DirectorEntity?
}