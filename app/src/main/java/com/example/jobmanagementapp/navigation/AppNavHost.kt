package com.example.jobmanagementapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jobmanagementapp.ui.theme.screens.employee.AddEmployeeScreen
import com.example.jobmanagementapp.ui.theme.screens.employee.UpdateEmployeeScreen
import com.example.jobmanagementapp.ui.theme.screens.checkin.CheckInScreen
import com.example.jobmanagementapp.ui.theme.screens.home.HomeDepartmentsScreen
import com.example.jobmanagementapp.ui.theme.screens.home.HomeScreen
import com.example.jobmanagementapp.ui.theme.screens.login.LoginScreen
import com.example.jobmanagementapp.ui.theme.screens.register.RegisterScreen
import com.example.jobmanagementapp.ui.theme.screens.checkout.CheckOutScreen
import com.example.jobmanagementapp.ui.theme.screens.employee.ViewUploadScreen
import com.example.jobmanagementapp.ui.theme.screens.welcome.WelcomeScreen

@Composable
fun AppNavHost(modifier: Modifier=Modifier,
               navController:NavHostController= rememberNavController(),
               startDestination: String = ROUTE_WELCOME){
    NavHost(navController = navController,
        modifier =modifier, startDestination = startDestination){
        composable(ROUTE_HOME){
            HomeScreen(navController)
        }
        composable(ROUTE_WELCOME){
            WelcomeScreen(navController)
        }
        composable(ROUTE_REGISTER){
            RegisterScreen(navController)
        }
        composable(ROUTE_LOGIN){
            LoginScreen(navController)
        }
        composable(ROUTE_CHECK_IN){
            CheckInScreen(navController)
        }
        composable(ROUTE_CHECK_OUT){
            CheckOutScreen(navController)
        }
        composable(ROUTE_ADD_EMPLOYEE){
            AddEmployeeScreen(navController)
        }
        composable(ROUTE_UPDATE_EMPLOYEE+"/{id}"){ passedData ->
            UpdateEmployeeScreen(navController, passedData.arguments?.getString("id")!!)
        }
        composable(ROUTE_HOMEDEPARTMENT){
            HomeDepartmentsScreen(navController)
        }
        composable(ROUTE_VIEW_UPLOAD){
            ViewUploadScreen(navController)
        }

    }
}