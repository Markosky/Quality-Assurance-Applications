package com.example.testcasemanager.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "test_cases")
data class TestCase(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val description: String,
    val expectedResult: String,
    val priority: String
)
