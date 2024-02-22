package app.junsu.test.data.music

import javax.inject.Inject

abstract class MusicRepository {
    abstract fun fetchPlayLists(): List<PlayList>
}

class MusicRepositoryImpl @Inject constructor(): MusicRepository() {
    override fun fetchPlayLists(): List<PlayList> = dummyPlayList
}
