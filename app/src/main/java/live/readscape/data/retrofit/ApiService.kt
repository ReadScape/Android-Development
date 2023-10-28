package live.readscape.data.retrofit

import live.readscape.data.response.AkunResponse
import live.readscape.data.response.LoginResponse
import live.readscape.data.response.SignupResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST("signup")
    suspend fun signUp(
        @Field("username") username: String,
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("privacy") privacy: Boolean,
        @Field("share") share: Boolean,
    ) : SignupResponse

    @FormUrlEncoded
    @POST("login")
    suspend fun login(
        @Field("username") username: String,
        @Field("password") password: String,
    ) : LoginResponse

    @GET("akun")
    suspend fun akun(
    ) : AkunResponse
}