package com.example.jobmanagementapp.ui.theme.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jobmanagementapp.R
import com.example.jobmanagementapp.navigation.ROUTE_ADD_EMPLOYEE
import com.example.jobmanagementapp.navigation.ROUTE_HOME
import com.example.jobmanagementapp.navigation.ROUTE_LOGIN
import com.example.jobmanagementapp.navigation.ROUTE_REGISTER
import com.example.jobmanagementapp.navigation.ROUTE_CHECK_IN
import com.example.jobmanagementapp.navigation.ROUTE_UPDATE_EMPLOYEE
import com.example.jobmanagementapp.navigation.ROUTE_VIEW_EMPLOYEE

@Composable
fun HomeDepartmentsScreen(navController: NavController){
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.office),
            contentDescription = "Home Page",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )

        Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally) {
            androidx.compose.material3.BottomAppBar(
                actions = {
                    IconButton(onClick = { navController.navigate(ROUTE_HOME) }) {
                        Icon(
                            Icons.Filled.KeyboardArrowLeft,
                            contentDescription = "Back"
                        )

                    }

                    IconButton(onClick = { navController.navigate(ROUTE_HOME) }) {
                        Icon(
                            Icons.Filled.Home,
                            contentDescription = "Home"
                        )

                    }

                    IconButton(onClick = { navController.navigate(ROUTE_CHECK_IN) }) {
                        Icon(
                            Icons.Filled.Email,
                            contentDescription = "Localized description"
                        )

                    }
                    IconButton(onClick = { navController.navigate(ROUTE_LOGIN) }) {
                        Icon(
                            Icons.Filled.AccountCircle,
                            contentDescription = "Localized description"
                        )

                    }

                    IconButton(onClick = { navController.navigate(ROUTE_LOGIN) }) {
                        Icon(
                            Icons.Filled.Search,
                            contentDescription = "Search"
                        )

                    }

                },
                floatingActionButton = {
                    FloatingActionButton(
                        onClick = { navController.navigate(ROUTE_ADD_EMPLOYEE) },
                        containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                        elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
                    ) {
                        Icon(
                            Icons.Filled.Add,
                            contentDescription = "Localized description"
                        )

                    }
                }

            )
            Spacer(modifier = Modifier.height(150.dp))

            Column(modifier=Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally) {
                val image = painterResource(
                    id = R.drawable.mee
                )
                Image(
                    painter = image,
                    contentDescription = null,
                    modifier = Modifier
                        .size(200.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(20.dp))
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row {
                ElevatedButton(onClick = {navController.navigate(ROUTE_VIEW_EMPLOYEE) })
                {
                    Text(text = "VIEW EMPLOYEES")
                }
                ElevatedButton(onClick = {navController.navigate(ROUTE_UPDATE_EMPLOYEE) })
                {
                    Text(text = "UPDATE EMPLOYEES")
                }
            }
            Button(onClick = {navController.navigate(ROUTE_ADD_EMPLOYEE)},
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(Color.Black)) {
                Text(text = "Enter your details", color = Color.Green)

            }
        }
    }
}



@Preview(showSystemUi = true, showBackground = true)
@Composable
fun HomeDepartmentScreenPreview(){
    HomeDepartmentsScreen(rememberNavController())
}

