package com.example.assignment.datasource.assignment1.entity


import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import org.hibernate.annotations.UuidGenerator
import java.time.LocalDate


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "movie")
class MovieEntity {

    @Id
    @Column
    @UuidGenerator
    lateinit var id: String

    @Column
    lateinit var title: String

    @Column
    var releaseYear: Int? = null

    @Column
    var releaseDate: LocalDate? = null

    @ManyToMany(mappedBy = "movies", cascade = [(CascadeType.PERSIST), (CascadeType.MERGE)])
     var directors: MutableSet<DirectorEntity> = mutableSetOf()

    @ManyToMany(mappedBy = "movies" , cascade = [(CascadeType.PERSIST), (CascadeType.MERGE)])
    lateinit var genres: MutableSet<GenreEntity>

}