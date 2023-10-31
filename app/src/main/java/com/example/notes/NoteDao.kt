package com.example.notes

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE) //onConflict is used in case if same notes is being inserted
    suspend fun insert(note : Note)

    @Delete
    suspend fun delete(note : Note)

    @Query("Select * from notes_table order by id ASC")
    fun getAllNotes() : LiveData <List<Note>>
    //we used LiveData so that if there is any changes in the table then the activity is aware of that
}
//after this we create DataBAse which will give data to our repository and it will be a singleton
// and it is singleton because we want our DB to be accessed from single location only at a time