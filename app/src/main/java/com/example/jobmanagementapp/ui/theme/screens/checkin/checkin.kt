package com.example.jobmanagementapp.ui.theme.screens.checkin

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jobmanagementapp.R
import com.example.jobmanagementapp.data.AuthViewModel
import com.example.jobmanagementapp.navigation.ROUTE_CHECK_OUT
import com.example.jobmanagementapp.navigation.ROUTE_HOMEDEPARTMENT
import androidx.compose.material3.Text as Text

@Composable
fun CheckInScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.img),
            contentDescription = "Check In Page",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize())
    }
    Column() {
//        var name by remember { mutableStateOf(TextFieldValue("")) }
        var email by remember { mutableStateOf(TextFieldValue("")) }
        var password by remember { mutableStateOf(TextFieldValue("")) }
        var confirmpassword by remember { mutableStateOf(TextFieldValue("")) }
        var arrival by remember { mutableStateOf(TextFieldValue("")) }
        var context = LocalContext.current
        Column(
            modifier = Modifier
                .fillMaxSize(),

            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Check in here",
                color = Color.Black,
                fontFamily = FontFamily.SansSerif,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(15.dp))
//            OutlinedTextField(
//                value = name, onValueChange = { name = it },
//                label = { Text(text = "Enter Name") },
//                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(5.dp),
//            )

            Spacer(modifier = Modifier.height(15.dp))
            OutlinedTextField(value = email, onValueChange = { email = it },
                placeholder = { Text(text = "Enter Email") },
                leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "Email") },
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
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
                value = confirmpassword, onValueChange = { confirmpassword = it },
                placeholder = { Text(text = "Confirm Password")},
                leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "Password")},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
            Spacer(modifier = Modifier.height(15.dp))
            OutlinedTextField(value = arrival, onValueChange = { arrival = it },
                placeholder = { Text(text = "Enter Arrival") },
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
            Spacer(modifier = Modifier.height(15.dp))
            Button(
                onClick = { val mycheckin = AuthViewModel(navController, context)
                    mycheckin.checkin(email.text.trim(),password.text.trim(),confirmpassword.text.trim())
                    navController.navigate(ROUTE_HOMEDEPARTMENT)
                }, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Check In")
            }
            Spacer(modifier = Modifier.height(15.dp))
            Button(
                onClick = { navController.navigate(ROUTE_CHECK_OUT) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Had already checked in? Click to check out")

            }

        }
    }
}
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun CheckInpage(){
    CheckInScreen(rememberNavController())
}




