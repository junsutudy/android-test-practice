package app.junsu.test.core.network.retrofit

import app.junsu.test.core.network.model.PhotoResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface TestApiService {
    @GET("/v2/list")
    fun getPhotos(
        @Query("page") page: Int,
        @Query("limit") limit: Int,
    ): List<PhotoResponse>

    @GET("/id/{id}/info")
    fun getPhotoInfo(
        @Path("id") id: String,
    ): PhotoResponse
}


