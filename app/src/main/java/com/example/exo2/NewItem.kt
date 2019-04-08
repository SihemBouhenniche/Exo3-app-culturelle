package com.example.exo2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_new_item.*

class NewItem : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_item)
        val position = intent.extras.getInt("position")
        submitAddBtn.setOnClickListener(View.OnClickListener {
            val title = title_input.text.toString()
            val description = des_input.text.toString()
            val photoCard = R.drawable.images
            val rateCard = 0.0f
            MainActivity.listCard.add(position, Card(title,description,photoCard,rateCard))
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        })
    }
}
