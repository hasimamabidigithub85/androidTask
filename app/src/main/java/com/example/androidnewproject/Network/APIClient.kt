package Network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import java.util.concurrent.TimeUnit

object APIClient {





        val baseUrlLive="http://www.omdbapi.com"

    var cacheSize: Int = 10 * 1024 * 1024 // 10 MB`

    var retrofit: Retrofit? = null

     val getClient: APIInterface
         get() {
             val logging = HttpLoggingInterceptor()
             logging.level = HttpLoggingInterceptor.Level.BODY
             val client = OkHttpClient.Builder()
             client.connectTimeout(5, TimeUnit.MINUTES)
             client.readTimeout(5, TimeUnit.MINUTES)
             client.writeTimeout(5, TimeUnit.MINUTES)
             client.addInterceptor(logging)
             val retrofit = Retrofit.Builder()
                 .baseUrl(baseUrlLive)
                 .addConverterFactory(GsonConverterFactory.create())
                 .client(client.build())
                 .build()

             return retrofit.create(APIInterface::class.java)
         }

}