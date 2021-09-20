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

class CalendarFragment : Fragment() {

    private var taskAdapter: RVCalendarAdapter? = null

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_calendar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        calendar.firstDayOfWeek = 2
        initRecyclerView()
    }


    private fun addData(date: Long) {

        val jsonFileString = getJsonFromAssets(requireContext(), "tasks.json")
        val gson = Gson()
        val listOfTasksType = object : TypeToken<List<Tasks>>() {}.type
        val tasks: List<Tasks> = gson.fromJson(jsonFileString, listOfTasksType)
        for (i in tasks) {
            if (i.date_start?.toLong() == date) {
                taskAdapter?.submitData(tasks)
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

        addData(getOneDayPicker(calendar))

//        addNewTask.setOnClickListener {
//            val bundle = Bundle()
//            bundle.putString("date", calendar.date.toString())
//            (activity as MainActivity).navController.navigate(R.id.action_calendarFragment_to_taskDescription, bundle)
//        }
    }
}