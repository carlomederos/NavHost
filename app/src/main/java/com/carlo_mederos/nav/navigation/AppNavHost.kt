package com.carlo_mederos.nav.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.carlo_mederos.nav.Home
import com.carlo_mederos.nav.Profile

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = HomeRoute,
        modifier = modifier
    ) {
        composable<HomeRoute> {
            Home(
                onNavigateToProfile = { userId, userName ->
                    navController.navigate(ProfileRoute(userId, userName))
                }
            )
        }

        composable<ProfileRoute> { backStackEntry ->
            val route = backStackEntry.toRoute<ProfileRoute>()
            Profile(
                userId = route.userId,
                userName = route.userName,
                onBack = { navController.popBackStack() }
            )
        }
    }
}
