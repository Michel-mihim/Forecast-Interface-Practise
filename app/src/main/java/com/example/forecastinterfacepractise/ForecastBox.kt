package com.example.forecastinterfacepractise

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView

data class ForecastBox(val weekDay: String)

class ForecastBoxesAdapter(
    private val forecastBoxes: List<ForecastBox>
) : RecyclerView.Adapter<ForecastBoxesAdapter.ForecastBoxViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastBoxViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.forecast_box_view, parent, false)
        return ForecastBoxViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ForecastBoxViewHolder,
        position: Int
    ) {
        holder.bind(forecastBoxes[position])
    }

    override fun getItemCount() = forecastBoxes.size

    class ForecastBoxViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(forecastBox: ForecastBox) {

        }

    }
}