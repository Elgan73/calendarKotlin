package com.stark.calendarkotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.fragment_calendar.*
import java.util.*
import kotlin.collections.ArrayList

class CalendarFragment : Fragment() {

    private lateinit var taskAdapter: RVCalendarAdapter

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_calendar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        calendar.setFirstDayOfWeek(Calendar.MONDAY)
        calendar.refreshCalendar(Calendar.getInstance(Locale.getDefault()))


    }

    private fun receiveData(str: String) {
        val jsonFileString = getJsonFromAssets(requireContext(), "tasks.json")
        val gson = Gson()
        val listOfTasksType = object : TypeToken<List<Tasks>>() {}.type
        val tasks: List<Tasks> = gson.fromJson(jsonFileString, listOfTasksType)
        val tmp : MutableList<Tasks> = mutableListOf()
        tasks.forEach {
            val dt = formatDate(it.date_start)
            if (dt == str) {
                tmp.addAll(listOf(it))
                taskAdapter.submitData(tmp)
            } else {
                taskAdapter.submitData(tmp)
            }
        }
    }





    private fun initRecyclerView() {
        recView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            taskAdapter = RVCalendarAdapter()
            adapter = taskAdapter
        }
    }

    override fun onStart() {
        super.onStart()

        calendar.setOnDateClickListener {
            receiveData(formatDate(it.time))
        }
        addNewTask.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_calendarFragment_to_newTaskFragment)
        }
    }
}

