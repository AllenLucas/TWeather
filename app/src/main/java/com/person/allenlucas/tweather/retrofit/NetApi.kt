package com.person.allenlucas.tweather.retrofit

import com.person.allenlucas.tweather.db.CityBean
import com.person.allenlucas.tweather.db.CountyBean
import com.person.allenlucas.tweather.db.ProvinceBean
import com.person.allenlucas.tweather.gson.Weather
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NetApi {

    companion object {
        val API_SERVER_URL = "http://guolin.tech/api/"
        private const val API_PROVINCE = "china"
        private const val API_CITY = "china/{province}"
        private const val API_COUNTY = "china/{province}/{city}"
        private const val API_WEATHER ="weather"
        private const val WEATHER_KEY = "40631a1c5fdb473996f8394535db90f1"
    }

    @GET(API_PROVINCE)
    fun GetProvince(): Observable<ProvinceBean>

    /**
     * @param province 省的代号
     */
    @GET(API_CITY)
    fun GetCity(@Path("province") province: Int): Observable<CityBean>

    /**
     * @param province 省的代号
     * @param city 市的代号
     */
    @GET(API_COUNTY)
    fun GetCounty(@Path("province") province: Int,
                  @Path("city") city: Int): Observable<CountyBean>

    /**
     * @param cityId 查询城市代号
     * @param key 和风后台的认证key
     */
    @GET(API_WEATHER)
    fun GetWeather(@Query("cityid") cityId: Int,
                   @Query("key") key: String = WEATHER_KEY):Observable<Weather>

}