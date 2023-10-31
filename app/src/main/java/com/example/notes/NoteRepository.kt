package com.example.notes

import androidx.lifecycle.LiveData

class NoteRepository(private val noteDao: NoteDao) {

    val allNotes : LiveData<List<Note>> = noteDao.getAllNotes()

    suspend fun insert(note: Note) {
        noteDao.insert(note)
    }
     suspend fun delete(note: Note){
         noteDao.delete(note)
     }
}
//this is just adding a layer which provides cleaner API, this is not a part of android architecture