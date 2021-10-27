package com.stark.calendarkotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.akexorcist.snaptimepicker.SnapTimePickerDialog
import kotlinx.android.synthetic.main.fragment_newtask.*

class NewTaskFragment : Fragment() {

    private var time: Long = 0

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_newtask, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val timeStartPicker = view.findViewById<TextView>(R.id.timeStart)
        val timeEndPicker = view.findViewById<TextView>(R.id.timeEnd)
        val todayDate = view.findViewById<TextView>(R.id.todayDate)

        arguments?.getLong("todayDate").let {
            todayDate.text = formatDate(it!!)
            time = it
        }

        timeStartPicker.setOnClickListener {
            val dialog = SnapTimePickerDialog.Builder().build()
            dialog.show(childFragmentManager, SnapTimePickerDialog.TAG)
            dialog.apply {
                setListener { h, m ->
                    var hour = h.toString()
                    var minute = m.toString()
                    if (h.length() < 2) {
                        hour = "0$hour"
                    }
                    if (m.length() < 2) {
                        minute = "0$minute"
                    }
                    timeStartPicker.text = getString(R.string.concatenateHoursAndMinutes, hour, minute)
                }
            }
        }

        timeEndPicker.setOnClickListener {
            val dialog = SnapTimePickerDialog.Builder().build()
            dialog.show(childFragmentManager, SnapTimePickerDialog.TAG)
            dialog.apply {
                setListener { h, m ->
                    var hour = h.toString()
                    var minute = m.toString()
                    if (h.length() < 2) {
                        hour = "0$hour"
                    }
                    if (m.length() < 2) {
                        minute = "0$minute"
                    }
                    timeEndPicker.text = getString(R.string.concatenateHoursAndMinutes, hour, minute)
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        saveTaskBtn.setOnClickListener {

            print(fromTextViewToLongTimestamp(timeStart, todayDate))
            print(fromTextViewToLongTimestamp(timeEnd, todayDate))
            (activity as MainActivity).navController.navigate(R.id.action_newTaskFragment_to_calendarFragment)

//            val idTask = Random.nextInt(2, 10000)
//            val task = Tasks(idTask, fromTextViewToLongTimestamp(timeStart, todayDate), fromTextViewToLongTimestamp(timeEnd, todayDate), fromTvToString(titleTask), fromTvToString(descriptionTask))
//            saveData(task, "tasks1.json")
        }
    }
}