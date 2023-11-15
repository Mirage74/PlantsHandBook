package com.example.plantshandbook

import android.os.Bundle
import android.text.Layout
import androidx.activity.ComponentActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.plantshandbook.databinding.ActivityMainBinding


class MainActivity : ComponentActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter = PlantAdapter()
    private val imageIdList = listOf(
        R.drawable.plant1,
        R.drawable.plant2,
        R.drawable.plant3,
        R.drawable.plant4,
        R.drawable.plant5
    )

    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        init()
    }

    private fun init() {
        binding.apply {
            rcView.layoutManager = LinearLayoutManager(this@MainActivity)
            //rcView.layoutManager = GridLayoutManager(this@MainActivity, 3)
            rcView.layoutManager = LinearLayoutManager(this@MainActivity)
            rcView.adapter = adapter
            buttonAdd.setOnClickListener {
                val plant = Plant(imageIdList[index], "Plant ${index + 1}")
                adapter.addPlant(plant)
                index++
                if (index == imageIdList.size) {
                    index = 0
                }

            }
        }
    }
}

