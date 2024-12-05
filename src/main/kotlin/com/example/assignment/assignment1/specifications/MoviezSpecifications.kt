package com.example.assignment.datasource.assignment1.specifications

import com.example.assignment.datasource.assignment1.entity.DirectorEntity
import com.example.assignment.datasource.assignment1.entity.GenreEntity
import com.example.assignment.datasource.assignment1.entity.MovieEntity
import jakarta.persistence.criteria.Join
import org.springframework.data.jpa.domain.Specification
import java.time.LocalDate

object MoviezSpecifications {

    fun releaseYearIs(year: Int?): Specification<MovieEntity>? {
        return year?.let{
            Specification<MovieEntity> { root, _, criteriaBuilder ->
                criteriaBuilder.equal(root.get<Int>("releaseYear"), it)
            }
        }
    }

    fun genreIdIs(genreId: String?): Specification<MovieEntity>? {
        return genreId?.let {
            Specification<MovieEntity> { root, _, criteriaBuilder ->
                val join: Join<MovieEntity, GenreEntity> = root.join("genres")
                criteriaBuilder.equal(join.get<String>("id"), it)
            }
        }
    }

    fun directorIdIs(directorId: String?): Specification<MovieEntity>? {
        return directorId?.let {
            Specification<MovieEntity> { root, _, criteriaBuilder ->
                val join: Join<MovieEntity, DirectorEntity> = root.join("directors")
                criteriaBuilder.equal(join.get<String>("id"), it)
            }

        }
    }

    fun releaseDateIs(date: LocalDate?): Specification<MovieEntity>? {
        return date?.let {
            Specification<MovieEntity> { root, _, criteriaBuilder ->
                criteriaBuilder.greaterThanOrEqualTo(root.get<LocalDate>("releaseDate"), it)
//            Specification<MovieEntity> { root, _, criteriaBuilder ->
//                criteriaBuilder.equal(root.get<LocalDate>("releaseDate"), it)

            }
        }
    }



    fun buildSpec(year: Int?, genreId: String?, directorId: String?, releaseDate: LocalDate?): Specification<MovieEntity> {

        return Specification.where(releaseYearIs(year))
            ?.and(genreIdIs(genreId))
            ?.and(directorIdIs(directorId))
            ?.and(releaseDateIs(releaseDate))
            ?: Specification { _, _, criteriaBuilder -> criteriaBuilder.conjunction() }
    }

}