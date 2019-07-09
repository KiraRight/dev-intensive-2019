package ru.skillbranch.devintensive.extensions

fun String.truncate(maxLength: Int = 16): String {
    var resultString = this.trim()
    if (resultString.length > maxLength) {
        resultString = resultString.substring(0, maxLength).trim() + "..."
    }
    return resultString
}

fun String.stripHtml(): String {
    val tag = Regex("<.*?>")
    val escapes = Regex("&[a-z]{1,4}?;|&#\\d+;")
    val space = Regex(" +")
    return this.replace(tag, "").replace(escapes, "").replace(space, " ")}