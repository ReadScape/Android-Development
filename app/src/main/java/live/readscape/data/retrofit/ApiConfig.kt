package live.readscape.data.retrofit

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiConfig {
    companion object {
        fun getApiService(token: String? = null): ApiService {
            val client = if(token == null) {
                OkHttpClient.Builder()
                    .build()
            } else {
                val authInterceptor = Interceptor { chain ->
                    val req = chain.request()
                    val requestHeaders = req.newBuilder()
                        .addHeader("Authorization", "$token")
                        .build()
                    chain.proceed(requestHeaders)
                }
                OkHttpClient.Builder()
                    .addInterceptor(authInterceptor)
                    .build()
            }
            val retrofit = Retrofit.Builder()
                .baseUrl("http://irham.ahqof.com/readscape/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}
