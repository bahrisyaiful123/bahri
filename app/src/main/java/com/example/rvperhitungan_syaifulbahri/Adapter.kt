package com.example.testttt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rvperhitungan_syaifulbahri.R

class Adapter (private val dataset : MutableList<Data>):
        RecyclerView.Adapter<Adapter.DataHolder>(){
        class DataHolder(view: View) : RecyclerView.ViewHolder(view){
            //val textA = view.findViewById<TextView>(R.id.txtA)
            //val textB = view.findViewById<TextView>(R.id.txtB)
            val textHasil = view.findViewById<TextView>(R.id.txtHasil2)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.activity_adapter, parent, false
        )
        return DataHolder(view)
    }

    override fun onBindViewHolder(holder: DataHolder, position: Int) {
        val data = dataset[position]
        //holder.textA.text = dataset[position].text1
        //holder.textB.text = dataset[position].text2
        holder.textHasil.text = dataset[position].hasil
    }

    override fun getItemCount(): Int {
        return  dataset.size
    }
}