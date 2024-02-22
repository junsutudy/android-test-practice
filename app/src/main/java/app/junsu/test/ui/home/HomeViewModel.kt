package app.junsu.test.ui.home

import androidx.lifecycle.ViewModel
import app.junsu.test.data.music.MusicRepository
import app.junsu.test.data.music.PlayList
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val musicRepository: MusicRepository,
) : ViewModel() {
    fun fetchPlayLists(): List<PlayList> = musicRepository.fetchPlayLists()
}
