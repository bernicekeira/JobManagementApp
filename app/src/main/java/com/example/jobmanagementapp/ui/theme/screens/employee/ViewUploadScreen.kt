package com.example.jobmanagementapp.ui.theme.screens.employee

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.jobmanagementapp.data.EmployeeViewModel
import com.example.jobmanagementapp.models.Upload
import com.example.jobmanagementapp.navigation.ROUTE_UPDATE_EMPLOYEE


@Composable
fun ViewUploadScreen(navController:NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        var context = LocalContext.current
        var employeeRepository = EmployeeViewModel(navController, context)


        val emptyUploadState = remember { mutableStateOf(Upload("","","","","")) }
        var emptyUploadsListState = remember { mutableStateListOf<Upload>() }

        var uploads = employeeRepository.viewUploads(emptyUploadState, emptyUploadsListState)


        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "All uploads",
                fontSize = 30.sp,
                fontFamily = FontFamily.Cursive,
                color = Color.Blue)

            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn(){
                items(uploads){
                    UploadItem(
                        name = it.name,
                        contact = it.contact,
                        email= it.email,
                        imageUrl = it.imageUrl,
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
fun UploadItem(name:String, contact:String, email:String, imageUrl:String, id:String,
               navController:NavHostController, employeeRepository:EmployeeViewModel) {

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = name)
        Text(text = contact)
        Text(text = email)
        Image(
            painter = rememberAsyncImagePainter(imageUrl),
            contentDescription = null,
            modifier = Modifier.size(128.dp)
        )
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