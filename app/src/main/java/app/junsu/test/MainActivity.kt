package app.junsu.test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import app.junsu.test.ui.music.MusicScreen
import app.junsu.test.ui.theme.TestExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestExampleTheme {
                MusicScreen()
            }
        }
    }
}
