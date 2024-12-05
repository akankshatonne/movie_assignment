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
@Table(name = "director")
class DirectorEntity {

    @Id
    @Column
    @Generated
    lateinit var id: String

    @Column
    lateinit var name: String

    @Column
    lateinit var nationality: String

    @ManyToMany(cascade = [(CascadeType.PERSIST), (CascadeType.MERGE)])
    @JoinTable(
        name = "movie_director",
        joinColumns = [JoinColumn(name = "director_id")],
        inverseJoinColumns = [JoinColumn(name = "movie_id")]
    )
    lateinit var movies: MutableSet<MovieEntity>

}