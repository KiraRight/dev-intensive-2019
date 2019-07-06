package com.example.devintensive.utils

object Utils {
    fun parseFullName(fullName:String?):Pair<String?, String?>{

        val parts : List<String>? = fullName?.split(" ")

        var firstName = parts?.getOrNull(0)
        var lastName = parts?.getOrNull(1)

        if(firstName == null || firstName == "")
            return Pair(null, null)
        if(lastName == null || lastName == "")
            return Pair(firstName, null)

        return Pair(firstName, lastName)
    }

    fun transliteration(payload: String, divider:String = " "): String {
        TODO()
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        if(firstName == null || firstName == "" || firstName == " ")
            return null

        if(lastName == null || lastName == "" || lastName == " ")
            return firstName?.substring(0,1)?.toUpperCase()

        var firstNameInitial = firstName?.substring(0,1)?.toUpperCase()
        var lastNameInitial = lastName?.substring(0,1)?.toUpperCase()

        return "$firstNameInitial$lastNameInitial"

    }
}