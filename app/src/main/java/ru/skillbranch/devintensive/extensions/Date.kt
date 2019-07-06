package com.example.devintensive.extensions

import java.lang.IllegalArgumentException
import java.text.SimpleDateFormat
import java.util.*

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.format(pattern: String = "HH:mm:ss dd.MM.yy"): String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value: Int, units:TimeUnits = TimeUnits.SECOND) : Date {
    var time = this.time

    time += when (units) {
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
        else -> throw IllegalArgumentException("Invalid unit")
    }

    this.time = time
    return this
}

fun Date.humanizeDiff(date:Date = Date()): String {
    var now = date.time
    var time = this.time
    var diff = time - now

    var message = ""

    diff/=1000
    if(diff.compareTo(0) == 0)
        return "только что"

    if(diff > 0) {
        if(diff < 60)
            return "через $diff cекунд"
        diff/=60
        if(diff < 60)
            return "через $diff минуты"
        diff/=60
        if(diff < 24)
            return "через $diff часов"
        diff/=24
        if(diff < 365)
            return "через $diff дней"
        diff/=365
        if(!diff.equals(0))
            return "более чем через год"
        else
            return "через год"
    } else {
        diff*=(-1)
        if(diff < 60)
            return "$diff cекунд назад"
        diff/=60
        if(diff < 60)
            return "$diff минуты назад"
        diff/=60
        if(diff < 24)
            return "$diff часа назад"
        diff/=24
        if(diff < 365)
            return "$diff дней назад"
        diff/=365
        if(diff.compareTo(0) != 0)
            return "более года назад"
        else
            return "год назад"
    }


    return message
}


enum class TimeUnits{
    SECOND,
    MINUTE,
    HOUR,
    DAY
}
