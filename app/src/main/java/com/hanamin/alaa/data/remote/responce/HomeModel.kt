package com.hanamin.alaa.data.remote.responce


data class HomeModel(
    val data: MutableList<Data?> = mutableListOf(),
)

data class Data(
    val sets: MutableList<Sets?> = mutableListOf()
)



