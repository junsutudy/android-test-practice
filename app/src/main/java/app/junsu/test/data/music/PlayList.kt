package app.junsu.test.data.music

data class PlayList(
    val id: Long,
    val title: String,
    val madeBy: String,
)

val dummyPlayList = listOf(
    PlayList(
        id = 1,
        title = "처음처럼",
        madeBy = "성시경",
    ),
    PlayList(
        id = 2,
        title = "Memories",
        madeBy = "Maroon 5",
    ),
    PlayList(
        id = 3,
        title = "Stan",
        madeBy = "Eminem",
    ),
    PlayList(
        id = 4,
        title = "Square",
        madeBy = "백예린",
    ),
)
