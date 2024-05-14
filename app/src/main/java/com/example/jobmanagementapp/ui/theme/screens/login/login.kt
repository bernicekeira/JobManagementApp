package com.example.jobmanagementapp.ui.theme.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jobmanagementapp.R
import com.example.jobmanagementapp.data.AuthViewModel
import com.example.jobmanagementapp.navigation.ROUTE_REGISTER


@Composable
fun LoginScreen(navController: NavController){
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.department),
            contentDescription = "Home Page",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize())
    }
    Column {

        var email by remember {
            mutableStateOf(TextFieldValue(""))
        }
        var pass by remember {
            mutableStateOf(TextFieldValue(""))
        }
        var context = LocalContext.current

        Column(modifier = Modifier
            .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Login here",
                color = Color.Black, fontFamily = FontFamily.SansSerif, fontSize = 30.sp)
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(value = email, onValueChange = {email = it},
                label = { Text(text = "Enter Email")},
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(value = pass, onValueChange = {pass = it},
                label = { Text(text = "Enter Password")},
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
            Spacer(modifier = Modifier
                .height(20.dp))
            Button(onClick = {
                val mylogin = AuthViewModel(navController, context)
                mylogin.login(email.text.trim(),pass.text.trim())
            },
                modifier = Modifier.fillMaxWidth()) {
                Text(text = "Log In")
            }
            Spacer(modifier = Modifier
                .height(20.dp))
            Button(onClick = { navController.navigate(ROUTE_REGISTER)},
                modifier = Modifier.fillMaxWidth()) {
                Text(text = "Don't have an account? Click to Register")

            }

        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Loginpage(){
    LoginScreen(rememberNavController())
}
