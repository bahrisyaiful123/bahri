package com.example.rvperhitungan_syaifulbahri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testttt.Adapter
import com.example.testttt.Data

class MainActivity : AppCompatActivity() {

    private lateinit var tambah: Button
    private lateinit var kurang: Button
    private lateinit var kali: Button
    private lateinit var bagi: Button
    private lateinit var bil1: EditText
    private lateinit var bil2: EditText
    private lateinit var Hasil: TextView
    private lateinit var reset: Button
    private lateinit var tambahData : Button
    private lateinit var recyclerView : RecyclerView
    private lateinit var recyclerAdapter : RecyclerView.Adapter<*>
    private lateinit var viewManager : RecyclerView.LayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tambah = findViewById(R.id.btntambah)
        kurang = findViewById(R.id.btnkurang)
        kali = findViewById(R.id.btnkali)
        bagi = findViewById(R.id.btnbagi)
        bil1 = findViewById(R.id.text1)
        bil2 = findViewById(R.id.text2)
        Hasil = findViewById(R.id.hasil)
        reset = findViewById(R.id.btnreset)
        tambahData = findViewById(R.id.btnSimpan)
        recyclerView = findViewById(R.id.listdata)

        //membuat variabel kosong tipe array mutablelist untuk simpan data array
        //data array disimpan di data class SiswaData

        val data = mutableListOf<Data>()
        viewManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerAdapter =  Adapter(data)
        recyclerView.adapter = recyclerAdapter
        recyclerView.layoutManager = viewManager

        tambah.setOnClickListener { plus() }
        kurang.setOnClickListener { min() }
        kali.setOnClickListener { kalli() }
        bagi.setOnClickListener { baggi() }
        reset.setOnClickListener { resset() }

        //tombolsimpan
        tambahData.setOnClickListener{
            val satu = bil1.text.toString()
            val dua = bil2.text.toString()
            val hasil = Hasil.text.toString()

            val dataSiswa = Data(satu,dua,hasil)
            data.add(dataSiswa)
            recyclerAdapter.notifyDataSetChanged()
        }

    }

    fun plus() {
        val hitung = bil1.text.toString().toDouble() + bil2.text.toString().toDouble()
        Hasil.text = hitung.toString()
    }

    fun min() {
        val hitung = bil1.text.toString().toDouble() - bil2.text.toString().toDouble()
        Hasil.text = hitung.toString()

    }

    fun kalli() {
        val hitung = bil1.text.toString().toDouble() * bil2.text.toString().toDouble()
        Hasil.text = hitung.toString()

    }

    fun baggi() {
        val hitung = bil1.text.toString().toDouble() / bil2.text.toString().toDouble()
        Hasil.text = hitung.toString()

    }

    fun resset() {
        Hasil.text=0.toString()
        bil1.text.clear()
        bil2.text.clear()
    }

}