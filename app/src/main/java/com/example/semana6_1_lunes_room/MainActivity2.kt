package com.example.semana6_1_lunes_room

import DB.AppDataBase
import Entidad.Student
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity2 : AppCompatActivity() {

    private lateinit var appDB2:AppDataBase
    lateinit var lista:List<Student>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        appDB2=AppDataBase.getDatabase(this)
        val recycler:RecyclerView=findViewById(R.id.recyclerStudent)

        GlobalScope.launch {
            lista=appDB2.studetDao().listaStudent()
            withContext(Dispatchers.Main){
                recycler.layoutManager=LinearLayoutManager(applicationContext)
                recycler.adapter=Adapter(lista)
            }
        }



    }
}