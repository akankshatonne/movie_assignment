package com.example.assignment.scalars.converter

//import com.example.assignment.scalars.Date
//import jakarta.persistence.AttributeConverter
//import jakarta.persistence.Converter
//
//
//@Converter(autoApply = true)
//class DateScalarAttributeConverter : AttributeConverter<Date, String> {
//
//    override fun convertToDatabaseColumn(attribute:Date?): String? {
//        return attribute?.toString()
//    }
//
//    override fun convertToEntityAttribute(dbData: String?): Date? {
//        return if (dbData != null) {
//            Date()
//        } else {
//            null
//        }
//    }
//}