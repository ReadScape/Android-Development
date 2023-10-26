package live.readscape

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import live.readscape.ui.screen.splash.ScreenSignUp
import live.readscape.ui.screen.splash.ScreenSplash

@Composable
fun ReadscapeApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = "Screen Splash",
        modifier = modifier
    ) {
        composable("Screen Splash") {
            ScreenSplash(navController)
        }
        composable("Screen Sign Up") {
            ScreenSignUp(navController)
        }
    }
}