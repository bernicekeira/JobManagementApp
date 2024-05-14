package com.example.jobmanagementapp.ui.theme.screens.checkout

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.jobmanagementapp.R
import com.example.jobmanagementapp.navigation.ROUTE_HOME
import com.example.jobmanagementapp.navigation.ROUTE_LOGIN
import com.example.jobmanagementapp.navigation.ROUTE_CHECK_IN
import com.example.jobmanagementapp.navigation.ROUTE_CHECK_OUT


@Composable
fun SignOutScreen(navController: NavHostController) {

    Image(painter = painterResource(id = R.drawable.home),
        contentDescription ="CheckOut Page",
        contentScale = ContentScale.Crop )

    var name by remember {
        mutableStateOf("")
    }
    var contact by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("") }
    var password by remember {
        mutableStateOf("")
    }
    var departuretime by remember {
        mutableStateOf("")
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Check Out here",
            color = Color.Black,
            fontFamily = FontFamily.SansSerif,
            fontSize = 30.sp
        )
        OutlinedTextField(
            value = name, onValueChange ={name = it},
            placeholder = { Text(text = "Enter Name")},
            leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "Name")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(
            value = contact, onValueChange ={contact = it},
            placeholder = { Text(text = "Enter Contact")},
            leadingIcon = { Icon(imageVector = Icons.Default.Call, contentDescription = "Contact")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(
            value = email, onValueChange ={email = it},
            placeholder = { Text(text = "Enter Email")},
            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "Email")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(
            value = password, onValueChange = { password = it },
            placeholder = { Text(text = "Enter Password")},
            leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "Password")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(
            value = departuretime, onValueChange = { departuretime = it },
            placeholder = { Text(text = "Enter Departure")},

            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(15.dp))
        Button(onClick = {navController.navigate(ROUTE_HOME)},
            colors = ButtonDefaults.buttonColors(Color.Gray)){
            Text(text= "Check Out")
        }

        Spacer(modifier = Modifier.height(15.dp))
        Button(
            onClick = { navController.navigate(ROUTE_CHECK_OUT) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Didn't Sign Up? Click to Check in")

        }

        }
}
@Preview
@Composable
fun SignOutScreenPreview(){
    SignOutScreen(rememberNavController())
}

