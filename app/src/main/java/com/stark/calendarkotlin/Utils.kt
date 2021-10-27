package com.stark.calendarkotlin

import android.content.Context
import android.widget.TextView
import java.io.IOException
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.math.abs
import kotlin.math.log10

fun getJsonFromAssets(context: Context, fileName: String): String? {
    val jsonString: String
    try {
        jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
    } catch (ioException: IOException) {
        ioException.printStackTrace()
        return null
    }
    return jsonString
}

fun formatDate(str: Long): String {
    val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
    val instant = Instant.ofEpochMilli(str)
    val date = LocalDateTime.ofInstant(instant, ZoneId.systemDefault())
    return formatter.format(date)
}

fun formatTime(str: Long): String {
    val formatter = DateTimeFormatter.ofPattern("hh:mm")
    val instant = Instant.ofEpochMilli(str)
    val date = LocalDateTime.ofInstant(instant, ZoneId.systemDefault())
    return formatter.format(date)
}

fun Int.length() = when(this) {
    0 -> 1
    else -> log10(abs(toDouble())).toInt() + 1
}

fun fromTimeToMilli2(t: TextView) : Long {
    val tmp = t.text.toString()
    val time = SimpleDateFormat("hh:mm", Locale.getDefault()).parse(tmp)
    return time!!.time
}

fun fromDateToMilli(t: TextView) : Long{
    val tmp = t.text.toString()
    val parse = LocalDate.parse(tmp, DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.GERMANY))
    return parse.atStartOfDay(ZoneId.systemDefault()).toEpochSecond()
}

fun fromTextViewToLongTimestamp(time: TextView, date: TextView): Long {
    val parseTime = fromTimeToMilli2(time)
    val parseDate = fromDateToMilli(date)
    return parseDate + parseTime
}

//fun saveData(task: Tasks, fileName: String) {
//    val gson = Gson()
//    val jsonString = gson.toJson(task)
//    val file = File(fileName)
//    file.writeText(jsonString)
//}

