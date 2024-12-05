package com.example.assignment.scalars

import com.netflix.graphql.dgs.DgsScalar
import graphql.GraphQLContext
import graphql.execution.CoercedVariables
import graphql.language.StringValue
import graphql.language.Value
import graphql.schema.Coercing
import graphql.schema.CoercingParseLiteralException
import graphql.schema.CoercingParseValueException
import graphql.schema.CoercingSerializeException
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.util.*

@DgsScalar(name = "DateScalar")
class DateScalar: Coercing<LocalDate,String> {
    init{
        println("DateScalar initialized")
    }
    val FORMATTER = DateTimeFormatter.ISO_DATE
    override fun serialize(dataFetcherResult: Any,
                           graphQLContext: GraphQLContext,
                           locale: Locale): String {
        return if (dataFetcherResult is LocalDate) {

            dataFetcherResult.format(FORMATTER)
        } else {
            println("In serialize DateScalar")
            throw CoercingSerializeException("Expected a LocalDate object.")
        }
    }

    override fun parseValue(input: Any,
                            graphQLContext: GraphQLContext,
                            locale: Locale,): LocalDate {
        return try {
            println("In parseValue DateScalar")
            LocalDate.parse(input.toString(),FORMATTER)
        } catch (e: DateTimeParseException) {
            println("In serialize DateScalar")
            throw CoercingParseValueException("Invalid date format, expected yyyy-MM-dd.")
        }
    }

    override fun parseLiteral(input: Value<*>,
                              variables: CoercedVariables,
                              graphQLContext: GraphQLContext,
                              locale: Locale): LocalDate {
        return if (input is StringValue) {
            try {
                println("In parseLiteral DateScalar")
                LocalDate.parse(input.value,FORMATTER)
            } catch (e: DateTimeParseException) {
                throw CoercingParseLiteralException("Invalid date format, expected yyyy-MM-dd.")
            }
        } else {
            throw CoercingParseLiteralException("Expected a StringValue.")
        }
    }

    override fun valueToLiteral(
        input: Any,
        graphQLContext: GraphQLContext,
        locale: Locale,
    ): StringValue {
        return StringValue(this.serialize(input, graphQLContext, locale))
    }

}