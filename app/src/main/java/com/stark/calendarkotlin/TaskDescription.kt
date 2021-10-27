package com.stark.calendarkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_task_description.*

class TaskDescription : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_task_description, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val startT = arguments?.getLong("startTime")
        val endT = arguments?.getLong("endTime")
        val title = arguments?.getString("title")
        val description = arguments?.getString("desc")
            timeStartDesc.text = formatTime(startT!!)
            timeEndDesc.text = formatTime(endT!!)
            titleTaskDesc.text = title
            descriptionTaskDesc.text = description
    }
}

