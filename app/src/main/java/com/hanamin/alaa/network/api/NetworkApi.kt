package com.hanamin.alaa.network.api


import com.hanamin.alaa.constants.ApiConstants
import com.hanamin.alaa.data.remote.responce.HomeModel
import com.hanamin.alaa.data.remote.responce.Sets
import retrofit2.http.GET
import retrofit2.http.Url

interface NetworkApi {


    @GET
    suspend fun getHomeList(
        @Url suffix: String = ApiConstants.GET_LIST,
    ): HomeModel

}