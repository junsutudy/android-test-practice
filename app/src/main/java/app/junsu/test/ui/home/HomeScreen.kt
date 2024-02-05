package app.junsu.test.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    openPlayList: () -> Unit,
    onShowCurrentPlayingModal: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Androidpotify") },
            )
        },
        bottomBar = {
            Column(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Button(
                        onClick = onShowCurrentPlayingModal,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 12.dp),
                    ) {
                        Text(text = "음악 보러 가기")
                    }
                }
                BottomAppBar {
                    homeBottomAppBarItems.forEach { bottomAppBarItem ->
                        NavigationBarItem(
                            selected = true,
                            onClick = { },
                            icon = {
                                Icon(
                                    painter = painterResource(id = bottomAppBarItem.iconRes),
                                    contentDescription = null,
                                )
                            },
                            label = {
                                Text(text = bottomAppBarItem.label)
                            },
                        )
                    }
                }
            }
        },
    ) { padValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            ElevatedCard(
                modifier = Modifier.size(150.dp),
                onClick = openPlayList,
            ) {
                Text(text = "재생 목록으로 이동")
            }
        }
    }
}

val homeBottomAppBarItems: List<BottomAppBarItem> = listOf(
    BottomAppBarItem(
        iconRes = androidx.core.R.drawable.ic_call_answer,
        label = "홈",
    ),
    BottomAppBarItem(
        iconRes = androidx.core.R.drawable.ic_call_answer_video,
        label = "검색",
    ),
    BottomAppBarItem(
        iconRes = androidx.core.R.drawable.ic_call_decline,
        label = "라이브러리",
    ),
)

class BottomAppBarItem(
    val iconRes: Int,
    val label: String,
)
