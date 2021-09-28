package com.stark.calendarkotlin

import android.content.Context
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

fun formatDate(str: Long): String {
    val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm")
    val instant = Instant.ofEpochMilli(str)
    val date = LocalDateTime.ofInstant(instant, ZoneId.systemDefault())
    return formatter.format(date).substring(0,10)
}

fun formatTime(str: Long): String {
    val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm")
    val instant = Instant.ofEpochMilli(str)
    val date = LocalDateTime.ofInstant(instant, ZoneId.systemDefault())
    return formatter.format(date).substring(11,16)
}


