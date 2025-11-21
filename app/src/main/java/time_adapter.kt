package com.example.ezhednevnik20

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TimeAdapter(
    private val onClick: (Int) -> Unit
) : RecyclerView.Adapter<TimeAdapter.TimeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.time_list, parent, false)
        return TimeViewHolder(view)
    }

    override fun getItemCount() = 23

    override fun onBindViewHolder(holder: TimeViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class TimeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val timeText: TextView = itemView.findViewById(R.id.timeText)

        fun bind(hour: Int) {
            val formatted = String.format("%02d:00", hour)
            timeText.text = formatted

            itemView.setOnClickListener {
                onClick(hour)
            }
        }
    }
}