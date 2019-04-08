package com.example.exo2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_card_details.*
import kotlinx.android.synthetic.main.card.*

class CardDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_details)

        var bundle = intent.extras
        val titleCard = bundle.getString("title")
        val descriptionCard = bundle.getString("description")
        val photoCard = bundle.getInt("photo")
        val rateCard = bundle.getFloat("rate")

        description2.text = descriptionCard
        title2.text = titleCard
        photo2.setImageResource(photoCard)
        rate2.rating = rateCard
    }
}
