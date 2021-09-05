package com.stark.calendarkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_task_description.*
import java.lang.reflect.Array.set
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.ZoneId
import java.util.*

class TaskDescription : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_task_description, container, false)
    }

    override fun onStart() {
        super.onStart()

        arguments?.getString("date")?.let {
//            val dt = Instant.ofEpochSecond(it.toLong()).atZone(ZoneId.systemDefault()).toLocalDateTime()
            val cal : Calendar = Calendar.getInstance()
            val date = SimpleDateFormat("dd.MM.yyyy hh:mm").format()

//            tv_date.text = date.toString()
        }
    }



}

//val dt = Instant.ofEpochSecond(1510500494).atZone(ZoneId.systemDefault()).toLocalDateTime()