package com.stark.calendarkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_task_description.*
import java.lang.reflect.Array.set
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*

class TaskDescription : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_task_description, container, false)
    }

    override fun onStart() {
        super.onStart()

        arguments?.getString("date")?.let {
            tv_date.text = it
        }
    }



}

//            val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm");
//            val instant = Instant.ofEpochMilli(it.toLong())
//            val date = LocalDateTime.ofInstant(instant, ZoneId.systemDefault())
//            val str = formatter.format(date)