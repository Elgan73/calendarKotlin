package com.stark.calendarkotlin

import android.content.Context
import android.widget.CalendarView
import java.io.IOException
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

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

fun formatDate(str: String): String {
    val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm")
    val instant = Instant.ofEpochMilli(str.toLong())
    val date = LocalDateTime.ofInstant(instant, ZoneId.systemDefault())
    val myDate = formatter.format(date)
    return myDate
}

//fun getOneDayPicker(calendarView: CalendarView): Long {
//    var str = ""
//    calendarView.setOnDateChangeListener { view, y, m, d ->
//        str = d.toString() + "." + m.toString() + "." + y.toString()
//    }
//    return str
//}

fun getOneDayPicker(calendarView: CalendarView): Long {
    var date : Long = 0
    calendarView.setOnDateChangeListener{view,_,_,_ ->
        date = calendarView.date
        println(date)
    }
    return date
}


