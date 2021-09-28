package com.stark.calendarkotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.akexorcist.snaptimepicker.SnapTimePickerDialog
import com.akexorcist.snaptimepicker.TimeRange
import kotlinx.android.synthetic.main.fragment_newtask.*

class NewTaskFragment: Fragment() {

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
        timeStartPicker.setOnClickListener {
            val dialog = SnapTimePickerDialog.Builder().build()
            dialog.show(childFragmentManager, SnapTimePickerDialog.TAG)
            dialog.apply {
                setListener { h, m ->
                    val time = "0" + h.toString() + ":" + m.toString() + "0"
                    timeStartPicker.text = time

                }
            }
        }
    }

    private fun saveData() {

    }
}