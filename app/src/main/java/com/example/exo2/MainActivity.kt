package com.example.exo2

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.card.view.*
import kotlinx.android.synthetic.main.title_card.view.*

class MainActivity : AppCompatActivity() {
    var adapter:CardAdapter?=null
    var adapter2:CardAdapter?=null
    companion object {
        var listCard = ArrayList<Card>()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadItems()
        adapter = CardAdapter(listCard,this)
        card_list.adapter = adapter

        adapter2 = CardAdapter(listCard,this)
        card_grid.adapter = adapter2
    }

    fun loadItems(){
        listCard.add(Card("list_name","Films",R.drawable.film6,5.0f))
        listCard.add(Card("S.W.A.T","S.W.A.T. is a 2003 American action crime thriller film directed by Clark Johnson and starring Samuel L. Jackson, Colin Farrell, Michelle Rodriguez, LL Cool J, and Jeremy Renner. It is based on the 1975 television series of the same name. It was produced by Neal H. Moritz and released in the United States on August 8, 2003.",R.drawable.film1,3.0f))
        listCard.add(Card("The Orphanage","The Orphanage (Spanish: El Orfanato) is a 2007 Spanish horror film and the debut feature of Spanish filmmaker J. A. Bayona. The film stars Belén Rueda as Laura, Fernando Cayo as her husband, Carlos, and Roger Príncep as their adopted son Simón. The plot centers on Laura, who returns to her childhood home, an orphanage. Laura plans to turn the house into a home for disabled children, but after an argument with Laura, Simón goes missing.",R.drawable.film3,4.0f))
        listCard.add(Card("The GUNDOWN","Cole Brandt (Andrew W. Walker) faces one last bloody showdown in a lawless town to protect a saloon and a beautiful woman.",R.drawable.film5,2.0f))
        listCard.add(Card("Killing Down","A former intelligence officer (Matthew Tompkins) encounters the man who tortured him years earlier.",R.drawable.film6,5.0f))
        listCard.add(Card("Pirates of the Caribbean ","Pirates of the Caribbean is a series of five fantasy swashbuckler films produced by Jerry Bruckheimer and based on Walt Disney's eponymous theme park ride. Directors of the series include Gore Verbinski, Rob Marshall and Joachim Rønning and Espen Sandberg",R.drawable.film7,1.0f))

        listCard.add(Card("list_name","Feuilltons",R.drawable.film6,5.0f))
        listCard.add(Card("S.W.A.T","S.W.A.T. is a 2003 American action crime thriller film directed by Clark Johnson and starring Samuel L. Jackson, Colin Farrell, Michelle Rodriguez, LL Cool J, and Jeremy Renner. It is based on the 1975 television series of the same name. It was produced by Neal H. Moritz and released in the United States on August 8, 2003.",R.drawable.film1,3.0f))
        listCard.add(Card("The Orphanage","The Orphanage (Spanish: El Orfanato) is a 2007 Spanish horror film and the debut feature of Spanish filmmaker J. A. Bayona. The film stars Belén Rueda as Laura, Fernando Cayo as her husband, Carlos, and Roger Príncep as their adopted son Simón. The plot centers on Laura, who returns to her childhood home, an orphanage. Laura plans to turn the house into a home for disabled children, but after an argument with Laura, Simón goes missing.",R.drawable.film3,3.0f))
        listCard.add(Card("The GUNDOWN","Cole Brandt (Andrew W. Walker) faces one last bloody showdown in a lawless town to protect a saloon and a beautiful woman.",R.drawable.film5,3.0f))
        listCard.add(Card("Killing Down","A former intelligence officer (Matthew Tompkins) encounters the man who tortured him years earlier.",R.drawable.film6,4.0f))
        listCard.add(Card("Pirates of the Caribbean ","Pirates of the Caribbean is a series of five fantasy swashbuckler films produced by Jerry Bruckheimer and based on Walt Disney's eponymous theme park ride. Directors of the series include Gore Verbinski, Rob Marshall and Joachim Rønning and Espen Sandberg",R.drawable.film7,4.0f))

        listCard.add(Card("list_name","Spectales",R.drawable.film6,5.0f))
        listCard.add(Card("S.W.A.T","S.W.A.T. is a 2003 American action crime thriller film directed by Clark Johnson and starring Samuel L. Jackson, Colin Farrell, Michelle Rodriguez, LL Cool J, and Jeremy Renner. It is based on the 1975 television series of the same name. It was produced by Neal H. Moritz and released in the United States on August 8, 2003.",R.drawable.film1,4.0f))
        listCard.add(Card("The Orphanage","The Orphanage (Spanish: El Orfanato) is a 2007 Spanish horror film and the debut feature of Spanish filmmaker J. A. Bayona. The film stars Belén Rueda as Laura, Fernando Cayo as her husband, Carlos, and Roger Príncep as their adopted son Simón. The plot centers on Laura, who returns to her childhood home, an orphanage. Laura plans to turn the house into a home for disabled children, but after an argument with Laura, Simón goes missing.",R.drawable.film3,3.0f))
        listCard.add(Card("The GUNDOWN","Cole Brandt (Andrew W. Walker) faces one last bloody showdown in a lawless town to protect a saloon and a beautiful woman.",R.drawable.film5,5.0f))
        listCard.add(Card("Killing Down","A former intelligence officer (Matthew Tompkins) encounters the man who tortured him years earlier.",R.drawable.film6,2.0f))
        listCard.add(Card("Pirates of the Caribbean ","Pirates of the Caribbean is a series of five fantasy swashbuckler films produced by Jerry Bruckheimer and based on Walt Disney's eponymous theme park ride. Directors of the series include Gore Verbinski, Rob Marshall and Joachim Rønning and Espen Sandberg",R.drawable.film7,5.0f))

    }

    inner class CardAdapter:BaseAdapter{
        var context : Context?=null
        var listCardLocal = ArrayList<Card>()
        constructor(listCard : ArrayList<Card>,context : Context){
            this.listCardLocal = listCard
            this.context = context
        }
        override fun getItem(position: Int): Any {
            return listCardLocal.get(position)
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return listCardLocal.size
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val item = listCardLocal.get(position)

            if (item.title == "list_name"){
                var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                val layoutItem = inflator.inflate(R.layout.title_card,null)
                layoutItem.title_section.text = item.des!!
                layoutItem.addBtn.setOnClickListener(View.OnClickListener {
                    val intent = Intent(context,NewItem::class.java)
                    intent.putExtra("position",position+1)
                    context!!.startActivity(intent)
                })
                return layoutItem
            }else{
                var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                val layoutItem = inflator.inflate(R.layout.card,null)
                layoutItem.title.text = item.title!!
                layoutItem.photo.setImageResource(item.photo!!)
                layoutItem.description.text = item.des!!
                layoutItem.rating.rating = item.rate!!
                layoutItem.removeBtn.setOnClickListener(View.OnClickListener {
                    val builder = AlertDialog.Builder(this@MainActivity)

                    // Set the alert dialog title
                    builder.setTitle("Delete ${item.title} ?")

                    // Display a message on alert dialog
                    builder.setMessage("Are you sure to delete ${item.title} ?")

                    // Set a positive button and its click listener on alert dialog
                    builder.setPositiveButton("YES"){dialog, which ->
                        // Do something when user press the positive button
                        deleteItem(position)
                        Toast.makeText(applicationContext,"${item.title} has been deleted",Toast.LENGTH_SHORT).show()
                    }


                    // Display a negative button on alert dialog
                    builder.setNegativeButton("No"){dialog,which ->
                        Toast.makeText(applicationContext,"You are not agree.",Toast.LENGTH_SHORT).show()
                    }


                    // Display a neutral button on alert dialog
                    builder.setNeutralButton("Cancel"){_,_ ->
                        Toast.makeText(applicationContext,"You cancelled the dialog.",Toast.LENGTH_SHORT).show()
                    }

                    // Finally, make the alert dialog using builder
                    val dialog: AlertDialog = builder.create()

                    // Display the alert dialog on app interface
                    dialog.show()
                })
                layoutItem.setOnClickListener(View.OnClickListener {
                    //move to details
                    val intent = Intent(context,CardDetails::class.java)
                    intent.putExtra("title",item.title!!)
                    intent.putExtra("description",item.des!!)
                    intent.putExtra("photo",item.photo!!)
                    intent.putExtra("rate",item.rate!!)
                    context!!.startActivity(intent)
                })
                return layoutItem
            }
        }
    }

    fun deleteItem(position: Int){
        listCard.removeAt(position)
        this.adapter!!.notifyDataSetChanged()
    }

}
