package com.example.jobmanagementapp.ui.theme.screens.Employee

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.jobmanagementapp.data.EmployeeViewModel
import com.example.jobmanagementapp.models.Employee
import com.example.jobmanagementapp.navigation.ROUTE_UPDATE_EMPLOYEE



@Composable
fun ViewEmployeeScreen(navController:NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        val context = LocalContext.current
        val employeeRepository = EmployeeViewModel(navController, context)
        val emptyEmployeeState = remember { mutableStateOf(Employee("","","","")) }
        val emptyEmployeeListState = remember { mutableStateListOf<Employee>() }

        val employee = employeeRepository.viewEmployee(emptyEmployeeState, emptyEmployeeListState)


        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "All employees",
                fontSize = 30.sp,
                fontFamily = FontFamily.Cursive,
                color = Color.Red)

            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn(){
                items(emptyEmployeeListState){
                    EmployeeItem(
                        name = it.name,
                        contact = it.contact,
                        email = it.email,
                        id = it.id,
                        navController = navController,
                        employeeRepository = employeeRepository
                    )
                }
            }
        }
    }

}




@Composable
fun EmployeeItem(name:String, contact:String, email:String, id:String,
                navController:NavHostController, employeeRepository: EmployeeViewModel
) {

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = name)
        Text(text = contact)
        Text(text = email)
        Button(onClick = {
            employeeRepository.deleteEmployee(id)
        }) {
            Text(text = "Delete")
        }
        Button(onClick = {
            navController.navigate(ROUTE_UPDATE_EMPLOYEE+"/$id")
        }) {
            Text(text = "Update")
        }
    }

}

@Preview
@Composable
fun View() {
    ViewEmployeeScreen(rememberNavController())

}






