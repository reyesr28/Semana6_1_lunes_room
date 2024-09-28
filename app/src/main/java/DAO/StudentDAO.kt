package DAO

import Entidad.Student
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentDAO {

    @Insert
    fun insert(student: Student)

    @Query("select * from student")
    fun listaStudent():List<Student>

}