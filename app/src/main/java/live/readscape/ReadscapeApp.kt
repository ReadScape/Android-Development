package live.readscape

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import live.readscape.ui.screen.feed.ScreenFeed
import live.readscape.ui.screen.home.ScreenHome
import live.readscape.ui.screen.splash.ScreenLogIn
import live.readscape.ui.screen.splash.ScreenSignUp
import live.readscape.ui.screen.splash.ScreenSplash
import live.readscape.ui.screen.story.ScreenStory
import live.readscape.ui.screen.story.ScreenStoryDetail

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
        composable("Screen Log In") {
            ScreenLogIn(navController)
        }
        composable("Screen Home") {
            ScreenHome(
                onNavigateToStory = {
                    navController.navigate("Screen Story")
                },
                onNavigateToDetail = {
                    navController.navigate("Screen Story Detail/$it")
                }
            )
        }
        composable("Screen Feed") {
            ScreenFeed(navController)
        }
        composable("Screen Story") {
            ScreenStory()
        }
        composable("Screen Story Detail/{id}") {
            var id = navController.currentBackStackEntryAsState().value?.arguments?.getString("id")
            if(id == null) {
                id = "-1"
            }
            ScreenStoryDetail(id)
        }
    }
}