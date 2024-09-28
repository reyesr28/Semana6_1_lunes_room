package com.example.semana6_1_lunes_room

import Entidad.Student
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Adapter(val listaStudent:List<Student>):RecyclerView.Adapter<StudentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        return StudentViewHolder(layoutInflater.inflate(R.layout.card,parent,false))
    }

    override fun getItemCount(): Int =listaStudent.size

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val item=listaStudent[position]
        holder.render(item)
    }


}