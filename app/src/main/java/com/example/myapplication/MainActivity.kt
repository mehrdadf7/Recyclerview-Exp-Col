package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mainAdapter by lazy {
        return@lazy MainAdapter { subModel ->
            Toast.makeText(applicationContext, "${subModel.subTitle} clicked", Toast.LENGTH_SHORT)
                .show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = mutableListOf<MainModel>()
        for (i in 0..50) {
            items.add(
                MainModel(
                    "Item $i",
                    mutableListOf<SubModel>().apply {
                        add(
                            SubModel("SubModel ${i + 20}")
                        )
                        add(
                            SubModel("SubModel ${i + 30}")
                        )
                        add(
                            SubModel("SubModel ${i + 40}")
                        )
                    }
                )
            )
        }

        mainAdapter.addItems(items)

        rv_items.apply {
            setHasFixedSize(true)
            adapter = mainAdapter
        }

    }

}