package app.junsu.test.core.network

abstract class TestNetworkDataSource {
    abstract suspend fun getPhotos(): List<Photo>
    abstract suspend fun getPhoto(id: Int): Photo

}
