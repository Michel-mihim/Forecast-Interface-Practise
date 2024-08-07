package com.example.forecastinterfacepractise

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView

data class ForecastBox(val weekDay: String, val temperature: String, val weather: Int)

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
        private val weatherImageView: ImageView
        private val temperatureTextView: TextView

        init {
            weekDayTextView = itemView.findViewById(R.id.weekDay)
            weatherImageView = itemView.findViewById(R.id.weather)
            temperatureTextView = itemView.findViewById(R.id.temperature)
        }

        fun bind(forecastBox: ForecastBox) {
            weekDayTextView.text = forecastBox.weekDay
            temperatureTextView.text = forecastBox.temperature

            val temperatureColor = when (forecastBox.temperature) {
                "-5" -> R.color.color_minus_5
                "-4" -> R.color.color_minus_4
                "-3" -> R.color.color_minus_3
                "-2" -> R.color.color_minus_2
                "-1" -> R.color.color_minus_1
                "+1" -> R.color.color_plus_1
                "+2" -> R.color.color_plus_2
                "+3" -> R.color.color_plus_3
                "+4" -> R.color.color_plus_4
                "+5" -> R.color.color_plus_5
                else -> R.color.color_0
            }

            itemView.setBackgroundColor(itemView.context.getColor(temperatureColor))

            val weatherId = when (forecastBox.weather) {
                1 -> R.drawable.clouds
                else -> R.drawable.sun
            }

            weatherImageView.setImageResource(weatherId)
        }

    }
}