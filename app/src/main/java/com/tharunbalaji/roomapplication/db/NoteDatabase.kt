package com.tharunbalaji.roomapplication.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDatabase: RoomDatabase() {

    // STEP 1: Create function to access Dao by database
    abstract fun noteDao(): NoteDao

    // STEP 2: Create an database instance
    companion object {
        private var INSTANCE: NoteDatabase? = null

        fun getDatabase(context: Context) : NoteDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NoteDatabase::class.java,
                    "sampledb"
                ).build()

                INSTANCE = instance
                instance
            }
        }
    }
}


// DB -> (multiple screens)
// 1. common/global instance (co-routines) -> share
// 2. individual instances -> each screen