package com.example.forecastinterfacepractise

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView

data class ForecastBox(val weekDay: String, val temperature: String)

class ForecastBoxAdapter(
    private val forecastBoxes: List<ForecastBox>
) : RecyclerView.Adapter<ForecastBoxAdapter.ForecastBoxViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastBoxViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.forecast_box_view, parent, false)
        return ForecastBoxViewHolder(view)
    }

    override fun onBindViewHolder(holder: ForecastBoxViewHolder, position: Int) {
        holder.bind(forecastBoxes[position])
    }

    override fun getItemCount() = forecastBoxes.size

    class ForecastBoxViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val weekDayTextView: TextView
        private val temperatureTextView: TextView

        init {
            weekDayTextView = itemView.findViewById(R.id.weekDay)
            temperatureTextView = itemView.findViewById(R.id.temperature)
        }

        fun bind(forecastBox: ForecastBox) {
            weekDayTextView.text = forecastBox.weekDay
            temperatureTextView.text = forecastBox.temperature

            val temperatureColor = when (forecastBox.temperature) {
                "-5" -> "color_minus_5"
                "-4" -> "color_minus_4"
                "-3" -> "color_minus_3"
                "-2" -> "color_minus_2"
                "-1" -> "color_minus_1"
                "+1" -> "color_plus_1"
                "+2" -> "color_plus_2"
                "+3" -> "color_plus_3"
                "+4" -> "color_plus_4"
                "+5" -> "color_plus_5"
                else -> "color_0"
            }

            itemView.setBackgroundColor()
        }

    }
}