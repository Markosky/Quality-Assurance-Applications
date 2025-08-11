package com.example.testcasemanager.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TestCaseDao {
    @Query("SELECT * FROM test_cases")
    fun getAll(): LiveData<List<TestCase>>

    @Insert
    suspend fun insert(testCase: TestCase)

    @Delete
    suspend fun delete(testCase: TestCase)
}
