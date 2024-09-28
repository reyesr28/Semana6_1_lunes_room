package Entidad

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student")
data class Student (
    @PrimaryKey(autoGenerate = true)
    val id:Int?,

    @ColumnInfo(name = "nombre")
    val nombre:String?,

    @ColumnInfo(name = "apellido")
    val apellido:String?,

    @ColumnInfo(name = "correo")
    val correo:String?,

)


