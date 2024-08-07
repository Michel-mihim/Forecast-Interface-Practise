package com.example.forecastinterfacepractise

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val week_days_list = listOf(
            getString(R.string.day1),
            getString(R.string.day2),
            getString(R.string.day3),
            getString(R.string.day4),
            getString(R.string.day5),
            getString(R.string.day6),
            getString(R.string.day7)
        )

        val recyclerView = findViewById<RecyclerView>(R.id.forecastBoxesRecycler)
        recyclerView.adapter = ForecastBoxAdapter(
            forecastBoxes = List(90) {
                ForecastBox(week_days_list[it % 7])
            }
        )

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

    }
}