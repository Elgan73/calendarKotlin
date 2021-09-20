package com.stark.calendarkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

class RVCalendarAdapter : RecyclerView.Adapter<RVCalendarAdapter.ViewHolder>() {

    private var dataSet: List<Tasks> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.rv_item_view, parent, false)

        return ViewHolder(view)
    }

    fun submitData(tasks: List<Tasks>) {
        dataSet = tasks
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.start.text = formatDate(dataSet[position].date_start.toString())
        holder.finish.text = formatDate(dataSet[position].date_finish.toString())
        holder.nameTask.text = dataSet[position].name
        holder.description.text = dataSet[position].description
//        if (holder.nameTask.text.isNotEmpty()) {
//            holder.alarmIcon.visibility = View.VISIBLE
//        }

//        holder.itemView.setOnClickListener {
//            clickListener(dataSet[position].name)
//        }
    }

    override fun getItemCount() = dataSet.size




    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val start: TextView = itemView.findViewById(R.id.start)
        val finish: TextView = itemView.findViewById(R.id.finish)
        val nameTask: TextView = itemView.findViewById(R.id.task_label)
        val description: TextView = itemView.findViewById(R.id.task_desc)
//        val alarmIcon: ImageView = itemView.findViewById(R.id.alarm_icon)

    }
}
//            val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm");
//            val instant = Instant.ofEpochMilli(it.toLong())
//            val date = LocalDateTime.ofInstant(instant, ZoneId.systemDefault())
//            val str = formatter.format(date)