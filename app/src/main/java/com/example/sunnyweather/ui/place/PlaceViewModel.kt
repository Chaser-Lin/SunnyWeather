package com.example.sunnyweather.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.sunnyweather.logic.Repository
import com.example.sunnyweather.logic.model.Place

class PlaceViewModel: ViewModel() {
    private val searchLiveData = MutableLiveData<String>()

    val placeList = ArrayList<Place>()

    // 观察仓库层返回的LiveData对象
    // 每当searchPlaces()函数被调用时，switchMap()方法所对应的转换函数就会执行
    val placeLiveData = Transformations.switchMap(searchLiveData) { query ->
        Repository.searchPlaces(query)  // 调用仓库层中定义的searchPlaces()方法就可以发起网络请求
    }

    fun searchPlaces(query: String) {
        searchLiveData.value = query
    }
}