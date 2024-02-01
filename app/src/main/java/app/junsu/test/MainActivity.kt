package app.junsu.test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import app.junsu.test.ui.home.HomeScreen
import app.junsu.test.ui.playlist.PlayListScreen
import app.junsu.test.ui.theme.TestExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestExampleTheme {
                MusicApp()
            }
        }
    }
}

@Composable
fun MusicApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home",
    ) {
        composable("home") {
            HomeScreen(
                openPlayList = {
                    navController.navigate("play_list")
                },
            )
        }
        composable("play_list") {
            PlayListScreen(
                navigateUp = navController::navigateUp,
            )
        }
    }
}
