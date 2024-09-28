package com.example.semana6_1_lunes_room

import DB.AppDataBase
import Entidad.Student
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var appDB:AppDataBase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        appDB=AppDataBase.getDatabase(this)

        val txtNom:EditText=findViewById(R.id.txtNom)
        val txtApe:EditText=findViewById(R.id.txtApe)
        val txtCorreo:EditText=findViewById(R.id.txtCorreo)

        val btnGrabar:Button=findViewById(R.id.btnRegistrar)

        btnGrabar.setOnClickListener(){

            val student=Student(
                null,
                txtNom.text.toString(),
                txtApe.text.toString(),
                txtCorreo.text.toString()
            )

            GlobalScope.launch (Dispatchers.IO){
                appDB.studetDao().insert(student)
            }

            txtNom.text.clear()
            txtApe.text.clear()
            txtCorreo.text.clear()

        }

        val btnListar:Button=findViewById(R.id.btnListar)

        btnListar.setOnClickListener(){

            val i=Intent(this,MainActivity2::class.java)
            startActivity(i)

        }


    }
}