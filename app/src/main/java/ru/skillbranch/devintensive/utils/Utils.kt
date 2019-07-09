package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName:String?):Pair<String?, String?>{

        val fullNameWithout = fullName?.trim()
        val parts = fullNameWithout?.split(" ")
        val firstName = parts?.getOrNull(0).orEmpty().ifEmpty { null }
        val lastName = parts?.getOrNull(1).orEmpty().ifEmpty { null }

        return firstName to lastName
    }

    val transliterationData = mapOf(
        "а" to "a",
        "б" to "b",
        "в" to "v",
        "г" to "g",
        "д" to "d",
        "е" to "e",
        "ё" to "e",
        "ж" to "zh",
        "з" to "z",
        "и" to "i",
        "й" to "i",
        "к" to "k",
        "л" to "l",
        "м" to "m",
        "н" to "n",
        "о" to "o",
        "п" to "p",
        "р" to "r",
        "с" to "s",
        "т" to "t",
        "у" to "u",
        "ф" to "f",
        "х" to "h",
        "ц" to "c",
        "ч" to "ch",
        "ш" to "sh",
        "щ" to "sh'",
        "ъ" to "",
        "ы" to "i",
        "ь" to "",
        "э" to "e",
        "ю" to "yu",
        "я" to "ya"
    )

    fun transliteration(payload: String, divider: String = " "): String {

        val words = payload.split(" ")

        val trans = { word : String -> word.toCharArray().asSequence().map {
            var sym = if (transliterationData.containsKey(it.toString().toLowerCase())) {
                transliterationData[it.toString().toLowerCase()]
            } else {
                it.toString()
            }

            if (it.isUpperCase()) {
                sym = sym?.capitalize()
            }

            return@map sym
        }.toList().joinToString(separator = "")}
        return words.asSequence().map { trans(it) }.toList().joinToString(separator = divider)

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