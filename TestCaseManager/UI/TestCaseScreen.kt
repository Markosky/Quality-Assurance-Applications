package com.example.testcasemanager.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.testcasemanager.data.TestCase
import com.example.testcasemanager.viewmodel.TestCaseViewModel

@Composable
fun TestCaseScreen(viewModel: TestCaseViewModel) {
    val testCases by viewModel.testCases.observeAsState(emptyList())
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var expectedResult by remember { mutableStateOf("") }
    var priority by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Add Test Case", style = MaterialTheme.typography.h6)
        Spacer(Modifier.height(8.dp))
        BasicTextField(value = title, onValueChange = { title = it }, modifier = Modifier.fillMaxWidth())
        BasicTextField(value = description, onValueChange = { description = it }, modifier = Modifier.fillMaxWidth())
        BasicTextField(value = expectedResult, onValueChange = { expectedResult = it }, modifier = Modifier.fillMaxWidth())
        BasicTextField(value = priority, onValueChange = { priority = it }, modifier = Modifier.fillMaxWidth())
        Spacer(Modifier.height(8.dp))
        Button(onClick = {
            viewModel.addTestCase(TestCase(title = title, description = description, expectedResult = expectedResult, priority = priority))
            title = ""; description = ""; expectedResult = ""; priority = ""
        }) {
            Text("Add")
        }

        Spacer(Modifier.height(16.dp))
        Text("Test Cases", style = MaterialTheme.typography.h6)
        LazyColumn {
            items(testCases.size) { index ->
                val testCase = testCases[index]
                Card(modifier = Modifier.fillMaxWidth().padding(4.dp)) {
                    Column(modifier = Modifier.padding(8.dp)) {
                        Text("Title: ${testCase.title}")
                        Text("Desc: ${testCase.description}")
                        Text("Expected: ${testCase.expectedResult}")
                        Text("Priority: ${testCase.priority}")
                        Button(onClick = { viewModel.deleteTestCase(testCase) }) {
                            Text("Delete")
                        }
                    }
                }
            }
        }
    }
}
