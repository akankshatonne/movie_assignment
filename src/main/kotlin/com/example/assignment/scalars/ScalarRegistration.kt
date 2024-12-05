package com.example.assignment.scalars

import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsRuntimeWiring
import graphql.schema.GraphQLScalarType
import graphql.schema.idl.RuntimeWiring

//@DgsComponent
//class ScalarRegistration {
//    @DgsRuntimeWiring
//     fun configure(builder: RuntimeWiring.Builder): RuntimeWiring.Builder? {
//        return builder.scalar(
//            GraphQLScalarType.newScalar()
//            .name("Date")
//            .coercing(DateScalar())
//            .build())
//    }
//}