package com.stark.calendarkotlin

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import kotlinx.android.synthetic.main.fragment_calendar.*
import java.lang.Exception
import java.lang.StringBuilder
import java.text.SimpleDateFormat
import java.util.*

class CalendarFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_calendar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        calendar.firstDayOfWeek = 2
    }

    override fun onStart() {
        super.onStart()

        addNewTask.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("date", calendar.date.toString())
            (activity as MainActivity).navController.navigate(R.id.action_calendarFragment_to_taskDescription, bundle)
        }
    }

//    fun selectedFormatDay(str: String) : String {
//        try {
//            val formatter = SimpleDateFormat("dd-MM-yyyy'T'HH:mm:ss'Z'", Locale.ENGLISH)
//            val mDate = formatter.parse(str)
//            Log.e("DATE!!!!!", mDate.toString())
//        } catch (e: Exception) {
//            Log.e("DATE_ERROR", e.toString())
//        }
//        return
//    }
//    fun selectedDay() : String {
//        calendar.setOnDateChangeListener { view, year, month, day ->
//            var year = year
//            var month = month
//            var dayOfWeek = day
//            var date = StringBuilder()
//                    .append(dayOfWeek)
//                    .append(".")
//                    .append(month)
//                    .append(".")
//                    .append(year).toString()
//            return@setOnDateChangeListener date
//        }
//        return
//    }


}