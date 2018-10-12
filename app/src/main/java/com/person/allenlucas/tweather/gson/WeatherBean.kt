package com.person.allenlucas.tweather.gson

import com.google.gson.annotations.SerializedName

class WeatherBean {

    /**
     * @param updateTime 更新时间
     */
    data class Update(@SerializedName("loc") val updateTime: String)

    /**
     * @param cityName 查询城市名称
     * @param weatherId 所属城市天气id
     * @param update 更新信息
     */
    data class Basic(@SerializedName("city") val cityName: String,
                 @SerializedName("id") val weatherId: String,
                 val update: Update)



    /**
     *
     */
    data class AQICity(val aqi: String,val pm25: String)

    data class AQI(val city: AQICity)



    data class More(@SerializedName("txt") val info: String)

    data class Now(@SerializedName("tmp") val temperature: String,
                   @SerializedName("cond") val more: More)



    data class Sport(@SerializedName("txt") val info: String)

    data class CarWash(@SerializedName("txt") val info: String)

    data class Comfort(@SerializedName("txt") val info: String)

    data class Suggestion(@SerializedName("comf") val comfort: Comfort,
                          @SerializedName("cw") val carWash: CarWash,
                          val sport: Sport)


    data class Temperature(val max: String,val min: String)

    data class MoreByForecast(@SerializedName("txt_d") val info: String)

    data class Forecast(val date: String,@SerializedName("tmp") val temperature: Temperature,
                        @SerializedName("cond") val more: MoreByForecast)
}