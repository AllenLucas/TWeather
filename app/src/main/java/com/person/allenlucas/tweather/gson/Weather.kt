package com.person.allenlucas.tweather.gson

import com.google.gson.annotations.SerializedName

data class Weather(val status: String,val basic: WeatherBean.Basic,
                   val aqi: WeatherBean.AQI,val now: WeatherBean.Now,
                   val suggestion: WeatherBean.Suggestion,
                   @SerializedName("daily_forecast")
                   val forecastList: ArrayList<WeatherBean.Forecast>)