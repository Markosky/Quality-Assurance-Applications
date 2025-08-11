package com.example.testcasemanager.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TestCase::class], version = 1)
abstract class TestCaseDatabase : RoomDatabase() {
    abstract fun testCaseDao(): TestCaseDao

    companion object {
        @Volatile private var INSTANCE: TestCaseDatabase? = null

        fun getDatabase(context: Context): TestCaseDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TestCaseDatabase::class.java,
                    "test_case_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
