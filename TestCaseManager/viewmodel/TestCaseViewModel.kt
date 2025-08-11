package com.example.testcasemanager.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.testcasemanager.data.*
import kotlinx.coroutines.launch

class TestCaseViewModel(application: Application) : AndroidViewModel(application) {
    private val dao = TestCaseDatabase.getDatabase(application).testCaseDao()
    val testCases: LiveData<List<TestCase>> = dao.getAll()

    fun addTestCase(testCase: TestCase) = viewModelScope.launch {
        dao.insert(testCase)
    }

    fun deleteTestCase(testCase: TestCase) = viewModelScope.launch {
        dao.delete(testCase)
    }
}
