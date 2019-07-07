package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName:String?):Pair<String?, String?>{

        val fullNameWithout = fullName?.trim()
        val parts = fullNameWithout?.split(" ")
        val firstName = parts?.getOrNull(0).orEmpty().ifEmpty { null }
        val lastName = parts?.getOrNull(1).orEmpty().ifEmpty { null }

        return firstName to lastName
    }

    fun transliteration(payload: String, divider:String = " "): String {
        TODO()
    }

    fun toInitials(firstName: String?, lastName: String?): String? {

        val firstNameInitial = firstName?.trim()?.getOrNull(0)?.toUpperCase()
        val lastNameInitial = lastName?.trim()?.getOrNull(0)?.toUpperCase()
        val firstInit: String
        val lastInit: String

        firstInit = when(firstNameInitial == null) {
            true -> ""
            false -> firstNameInitial.toString()
        }

        lastInit = when(lastNameInitial == null) {
            true -> ""
            false -> lastNameInitial.toString()
        }

        return "$firstInit$lastInit".ifEmpty { null }

    }
}