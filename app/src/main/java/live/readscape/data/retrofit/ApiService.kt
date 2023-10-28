package live.readscape.data.retrofit

import live.readscape.data.response.AkunResponse
import live.readscape.data.response.LoginResponse
import live.readscape.data.response.SignupResponse
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @POST("signup")
    suspend fun signUp(
        @Query("username") username: String,
        @Query("email") email: String,
        @Query("password") password: String,
        @Query("privacy") privacy: Boolean,
        @Query("share") share: Boolean,
    ) : SignupResponse

    @POST("login")
    suspend fun login(
        @Query("username") username: String,
        @Query("password") password: String,
    ) : LoginResponse

    @GET("akun")
    suspend fun akun(
    ) : AkunResponse
}