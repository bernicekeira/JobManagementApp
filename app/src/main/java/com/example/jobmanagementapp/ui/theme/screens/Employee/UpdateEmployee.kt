package com.example.jobmanagementapp.ui.theme.screens.Employee

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
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
import com.example.jobmanagementapp.R
import com.example.jobmanagementapp.data.EmployeeViewModel
import com.example.jobmanagementapp.models.Employee
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

@Composable
fun UpdateEmployeeScreen(navController: NavHostController, id:String) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.home),
            contentDescription = "Home Page",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize())
    }
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        val context = LocalContext.current
        var name by remember { mutableStateOf("") }
        var contact by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }

        val currentDataRef = FirebaseDatabase.getInstance().getReference()
            .child("Products/$id")
        currentDataRef.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val employee = snapshot.getValue(Employee::class.java)
                name = employee!!.name
                contact = employee.contact
                email = employee.email
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
            }
        })

        Text(
            text = "Add employee",
            fontSize = 30.sp,
            fontFamily = FontFamily.Cursive,
            color = Color.Red,
            modifier = Modifier.padding(20.dp),
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline
        )

        var employeeName by remember { mutableStateOf(TextFieldValue(name)) }
        var employeeContact by remember { mutableStateOf(TextFieldValue(contact)) }
        var employeeEmail by remember { mutableStateOf(TextFieldValue(email)) }

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
            //-----------WRITE THE UPDATE LOGIC HERE---------------//
            val employeeRepository = EmployeeViewModel(navController, context)
            employeeRepository.updateEmployee(employeeName.text.trim(),employeeContact.text.trim(),
                employeeEmail.text.trim(),id)


        }) {
            Text(text = "Update")
        }

    }
}

@Preview
@Composable
fun Update() {
    UpdateEmployeeScreen(rememberNavController(), id = "")
}