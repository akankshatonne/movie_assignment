package com.example.assignment.datasource.assignment1.entity

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Data
import lombok.Generated
import lombok.NoArgsConstructor

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "genre")
class GenreEntity {

    @Id
    @Column
    @Generated
    lateinit var id: String

    @Column
    lateinit var name: String

    @ManyToMany(cascade = [(CascadeType.MERGE), (CascadeType.PERSIST)])
    @JoinTable(
        name = "movie_genre",
        joinColumns = [JoinColumn(name = "genre_id")],
        inverseJoinColumns = [JoinColumn(name = "movie_id")],
    )
    lateinit var movies: MutableSet<MovieEntity>

}