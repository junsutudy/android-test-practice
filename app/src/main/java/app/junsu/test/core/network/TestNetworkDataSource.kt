package app.junsu.test.core.network

import app.junsu.test.core.network.model.PhotoResponse

abstract class TestNetworkDataSource {
    abstract suspend fun getPhotos(page: Int, limit: Int): List<PhotoResponse>
    abstract suspend fun getPhoto(id: Int): PhotoResponse

}
