package kozlov.artyom.ctf.data.network

import kozlov.artyom.ctf.data.network.pojo.CurrencyDTO
import retrofit2.http.GET

interface CurrencyApi {
    @GET("daily_json.js")
    suspend fun getPost(): CurrencyDTO
}