package com.example.jobmanagementapp.ui.theme.screens.register

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
import com.example.jobmanagementapp.navigation.ROUTE_HOME
import com.example.jobmanagementapp.navigation.ROUTE_LOGIN
import androidx.compose.material3.Text as Text

@Composable
fun RegisterScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.com),
            contentDescription = "Register Page",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize())
    }
    Column() {
        var name by remember { mutableStateOf(TextFieldValue("")) }
        var email by remember { mutableStateOf(TextFieldValue("")) }
        var password by remember { mutableStateOf(TextFieldValue("")) }
        var confirmpassword by remember { mutableStateOf(TextFieldValue("")) }
        var context = LocalContext.current
        Column(
            modifier = Modifier
                .fillMaxSize(),

            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Register here",
                color = Color.Black,
                fontFamily = FontFamily.SansSerif,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(15.dp))
            OutlinedTextField(
                value = name, onValueChange = { name = it },
                label = { Text(text = "Enter Name") },
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
            )

            Spacer(modifier = Modifier.height(15.dp))
            OutlinedTextField(value = email, onValueChange = { email = it },
                label = { Text(text = "Enter Email") },
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            )

            Spacer(modifier = Modifier.height(15.dp))
            OutlinedTextField(value = password, onValueChange = { password = it },
                label = { Text(text = "Enter password") },
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            )
            Spacer(modifier = Modifier.height(15.dp))
            OutlinedTextField(
                value = confirmpassword, onValueChange = { confirmpassword = it },
                label = { Text(text = "Enter Confirm Password") },
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            )
            Spacer(modifier = Modifier.height(15.dp))
            Button(
                onClick = { val myregister = AuthViewModel(navController, context)
                    myregister.signup(email.text.trim(),password.text.trim(),confirmpassword.text.trim())
                    navController.navigate(ROUTE_HOME)
                }, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Register")
            }
            Spacer(modifier = Modifier.height(15.dp))
            Button(
                onClick = { navController.navigate(ROUTE_LOGIN) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Have an Account? Click to Login")

            }

        }
    }
}
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun Registerpage(){
    RegisterScreen(rememberNavController())
}


