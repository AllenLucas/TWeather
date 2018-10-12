package com.person.allenlucas.tweather.db

/**
 * @param id 县级的id
 * @param countyName 县级的名字
 * @param weatherId 县所对应的天气id
 * @param cityId 所属市的id
 */
data class CountyBean(val id: Int,val countyName: String,val weatherId:String,val cityId: Int)