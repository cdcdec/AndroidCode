package com.cdc.keyboard.beans

data class CityInfo(
    var city: String,
    var cityId: String,
    var parent: String,
    var updateTime: String
)

data class ForecastBean(
    var date:String,
    var sunrise:String,
    var high:String,
    var low:String,
    var sunset:String,
    var aqi:Int,
    var ymd:String,
    var week:String,
    var fx:String,
    var fl:String,
    var type:String,
    var notice:String
)

data class Yesterday(
    var date:String,
    var sunrise:String,
    var high:String,
    var low:String,
    var sunset:String,
    var aqi:Int,
    var ymd:String,
    var week:String,
    var fx:String,
    var fl:String,
    var type:String,
    var notice:String
)

data class DataResult(
    var shidu:String,
    var pm25:Int,
    var pm10:Int,
    var quality:String,
    var wendu:String,
    var ganmao:String,
    var yesterday:Yesterday,
    var forecast:MutableList<ForecastBean>
)

data class WeatherResultBean(
    var tiem:String,
    var date:String,
    var message:String,
    var status:Int,
    var cityInfo:CityInfo,
    var data:DataResult
)