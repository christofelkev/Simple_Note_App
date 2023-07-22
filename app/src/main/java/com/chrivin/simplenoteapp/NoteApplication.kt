package com.chrivin.simplenoteapp

import android.app.Application
import com.chrivin.simplenoteapp.Repository.NoteRepository
import com.chrivin.simplenoteapp.Room.NoteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class NoteApplication : Application() {
    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { NoteDatabase.getDatabase(this,applicationScope) }
    val repository by lazy { NoteRepository(database.getNoteDao()) }
}