package app.junsu.test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetValue
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import app.junsu.test.ui.home.HomeScreen
import app.junsu.test.ui.music.MusicScreen
import app.junsu.test.ui.playlist.PlayListScreen
import app.junsu.test.ui.theme.TestExampleTheme
import kotlinx.coroutines.launch

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MusicApp() {
    val navController = rememberNavController()
    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberStandardBottomSheetState(
            initialValue = SheetValue.Hidden,
            skipHiddenState = false,
        ),
    )
    val scope = rememberCoroutineScope()

    LaunchedEffect(scaffoldState.bottomSheetState) {
        if (scaffoldState.bottomSheetState.hasPartiallyExpandedState) {
            scope.launch {
                scaffoldState.bottomSheetState.hide()
            }
        }
    }

    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetContent = {
            MusicScreen(
                onHideCurrentPlayingModal = {
                    scope.launch {
                        scaffoldState.bottomSheetState.hide()
                    }
                },
            )
        },
        sheetDragHandle = null,
    ) {
        NavHost(
            navController = navController,
            startDestination = "home",
        ) {
            composable("home") {
                HomeScreen(
                    openPlayList = {
                        navController.navigate("play_list")
                    },
                    onShowCurrentPlayingModal = {
                        scope.launch {
                            scaffoldState.bottomSheetState.expand()
                        }
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
}
