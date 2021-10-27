package com.stark.calendarkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RVCalendarAdapter(private val cellClickListener: CellClickListener) : RecyclerView.Adapter<RVCalendarAdapter.ViewHolder>() {

    private var dataSet: MutableList<Tasks> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.rv_item_view, parent, false)
        return ViewHolder(view)
    }

    fun submitData(tasks: MutableList<Tasks>) {
            dataSet = tasks
            notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.start.text = formatTime(dataSet[position].date_start)
        holder.finish.text = formatTime(dataSet[position].date_finish)
        holder.nameTask.text = dataSet[position].name
        holder.description.text = dataSet[position].description

        holder.itemView.setOnClickListener {
            cellClickListener.onCellClickListener(dataSet[position])
        }
    }

    override fun getItemCount() = dataSet.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var start: TextView = itemView.findViewById(R.id.start)
        var finish: TextView = itemView.findViewById(R.id.finish)
        var nameTask: TextView = itemView.findViewById(R.id.task_label)
        var description: TextView = itemView.findViewById(R.id.task_desc)
    }
}
