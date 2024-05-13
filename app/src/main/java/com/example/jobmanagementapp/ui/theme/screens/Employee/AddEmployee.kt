package com.example.jobmanagementapp.ui.theme.screens.Employee

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.jobmanagementapp.data.EmployeeViewModel
import com.example.jobmanagementapp.navigation.ROUTE_VIEW_EMPLOYEE

@Composable
fun AddEmployeeScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        var context = LocalContext.current
        Text(
            text = "Add employee",
            fontSize = 35.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.White,
            modifier = Modifier.padding(20.dp),
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline
        )

        var employeeName by remember { mutableStateOf(TextFieldValue("")) }
        var employeeContact by remember { mutableStateOf(TextFieldValue("")) }
        var employeeEmail by remember { mutableStateOf(TextFieldValue("")) }

        OutlinedTextField(
            value = employeeName,
            onValueChange = { employeeName = it },
            label = { Text(text = "Employee name *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = employeeContact,
            onValueChange = { employeeContact = it },
            label = { Text(text = "Employee contact *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = employeeEmail,
            onValueChange = { employeeEmail = it },
            label = { Text(text = "Employee email *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {

            val employeeRepository = EmployeeViewModel(navController,context)
            employeeRepository.saveEmployee(employeeName.text.trim(),employeeContact.text.trim(),
                employeeEmail.text)
            navController.navigate(ROUTE_VIEW_EMPLOYEE)


        }) {
            Text(text = "Save")
        }

    }
}
@Preview
@Composable
fun AddEmployeeScreenPreview() {
    AddEmployeeScreen(rememberNavController())

}