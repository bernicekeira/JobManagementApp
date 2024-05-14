package com.example.jobmanagementapp.ui.theme.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jobmanagementapp.R
import com.example.jobmanagementapp.navigation.ROUTE_LOGIN
import com.example.jobmanagementapp.navigation.ROUTE_REGISTER
import com.example.jobmanagementapp.navigation.ROUTE_CHECK_IN
import com.example.jobmanagementapp.navigation.ROUTE_CHECK_OUT


@Composable
fun HomeScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.login),
            contentDescription = "Home Page",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
    }
    Column(modifier = Modifier
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        var context = LocalContext.current
//        var employeedata=employeeviewmodel(navController,context)
        Text(text = "Welcome to Home page",
            color = Color.Black,
            fontFamily = FontFamily.Cursive,
            fontSize = 30.sp)
        Spacer(modifier = Modifier.height(100.dp))
        Button(onClick = {navController.navigate(ROUTE_REGISTER)
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "REGISTER")
        }
        Spacer(modifier = Modifier.height(50.dp))
        Button(onClick = { navController.navigate(ROUTE_LOGIN)
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "LOGIN")
        }
        Spacer(modifier = Modifier.height(50.dp))
        Button(onClick = { navController.navigate(ROUTE_CHECK_IN)
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "CHECK IN")
        }
        Spacer(modifier = Modifier.height(50.dp))
        Button(onClick = { navController.navigate(ROUTE_CHECK_OUT)
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "CHECK OUT")
        }
    }

}


@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen(rememberNavController())
}

