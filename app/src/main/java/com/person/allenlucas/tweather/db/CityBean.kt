package com.person.allenlucas.tweather.db

/**
 * @param id 市级的id
 * @param cityName 市级的名字
 * @param cityCode 市级的代码
 * @param provinceCode 所属省级代码
 */
data class CityBean(val id: Int,val cityName: String,val cityCode: Int,val provinceCode: Int)