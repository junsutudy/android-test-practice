package app.junsu.test.core.network.retrofit

import retrofit2.http.GET


interface TestApiService {
    @GET("")
    fun getPhotos(): List<Photo>
}


