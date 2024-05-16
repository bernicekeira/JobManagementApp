package com.example.jobmanagementapp.ui.theme.screens.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jobmanagementapp.R
import com.example.jobmanagementapp.navigation.ROUTE_HOME
import com.example.jobmanagementapp.navigation.ROUTE_LOGIN
import com.example.jobmanagementapp.navigation.ROUTE_REGISTER

@Composable
fun WelcomeScreen(navController: NavController){
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.welcome),
            contentDescription = "Welcome Page",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize())
    }
    Column(modifier= Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Welcome",
            fontSize = 40.sp,
            fontWeight = FontWeight(900),
            color = Color.Black,
            fontFamily = FontFamily.Cursive,
            textDecoration = TextDecoration.Underline
        )
        Spacer(modifier = Modifier.height(50.dp))
        val image = painterResource(
            id = R.drawable.mee
        )
        Image(painter = image,
            contentDescription = null,
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop)
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Giving you greater opportunities to work flexibly.Your best choice with a friendly zone of work",
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.Cursive,
            fontSize = 25.sp,
            fontWeight = FontWeight(150),
            color = Color.Black
        )
        Spacer(modifier = Modifier.weight(0.7f))
        Button(onClick = { navController.navigate(ROUTE_HOME)},
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color.Black)) {
            Icon(imageVector = Icons.Default.Home, contentDescription ="Home", tint = Color.Green)
            Text(text = "Get Started",
                color = Color.Green)
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { navController.navigate(ROUTE_REGISTER)}, 
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color.Black)) {
            Icon(imageVector = Icons.Default.Email, contentDescription ="Email", tint = Color.Green)
            Text(text = "Register with Email",
                color = Color.Green)
        }
        Button(onClick = {navController.navigate(ROUTE_LOGIN)},
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color.Transparent)) {
            Text(text = "Have an account?",
                color = Color.Black)
            Text(text = "Login",
                color = Color.Black,
                fontWeight = FontWeight.Bold)
            
        }
        Spacer(modifier = Modifier.height(3.dp))
        Text(text = "Terms and Conditions Applied",
            color = Color.Black)

    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun WelcomeScreenPreview(){
    WelcomeScreen(rememberNavController())
}
