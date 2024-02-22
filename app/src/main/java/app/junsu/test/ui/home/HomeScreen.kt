package app.junsu.test.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import app.junsu.test.data.music.PlayList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    openPlayList: (
        playListId: Long,
        playListTitle: String,
    ) -> Unit,
    onShowCurrentPlayingModal: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val playList by remember {
        mutableStateOf(viewModel.fetchPlayLists())
    }

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
        /*Column(
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
        }*/
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padValues),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) { // %= RecyclerView
            items(playList) { item: PlayList ->
                ElevatedCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp),
                    onClick = {
                        openPlayList(
                            item.id,
                            item.title,
                        )
                    },
                ) {
                    Text(
                        modifier = Modifier.padding(all = 12.dp),
                        text = item.title,
                    )
                }
            }
        }
    }
}
/*

val playListItems = listOf(
    PlayList(
        id = 1,
        title = "좋아요 표시한 곡",
        madeBy = "박준수",
    ),
    PlayList(
        id = 2,
        title = "싫어요 표시한 곡",
        madeBy = "박준수",
    ),
    PlayList(
        id = 3,
        title = "you and i",
        madeBy = "IU",
    ),
    PlayList(
        id = 4,
        title = "성시경 베스트",
        madeBy = "성시경",
    ),
)
*/

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
