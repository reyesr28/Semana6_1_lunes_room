package com.example.semana6_1_lunes_room

import Entidad.Student
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentViewHolder(view:View):RecyclerView.ViewHolder(view) {

    val id=view.findViewById<TextView>(R.id.txtCardId)
    val nom=view.findViewById<TextView>(R.id.txtCardNom)
    val ape=view.findViewById<TextView>(R.id.txtcardApe)
    val correo=view.findViewById<TextView>(R.id.txtCardCorreo)

    fun render(studentModel: Student){
        id.text=studentModel.id.toString()
        nom.text=studentModel.nombre.toString()
        ape.text=studentModel.apellido.toString()
        correo.text=studentModel.correo.toString()
    }

}